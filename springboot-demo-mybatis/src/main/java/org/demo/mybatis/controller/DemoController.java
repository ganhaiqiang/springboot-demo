package org.demo.mybatis.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.demo.mybatis.model.Student;
import org.demo.mybatis.service.StudentService;
import org.demo.mybatis.service.impl.AddressTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Autowired
	private StudentService studentService;

	@GetMapping("selectByPrimaryKey")
	public Student selectByPrimaryKey(Integer id) {
		return studentService.selectByPrimaryKey(id);
	}

	@GetMapping("selectByPage")
	public Object selectByPage(int pageNum, int pageSize) {
		return studentService.selectByPage(pageNum, pageSize);
	}

	@GetMapping("excel")
	public void excel() throws InvalidFormatException, IOException, InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		XSSFWorkbook wb = new XSSFWorkbook(new File("C:/Users/Administrator/Desktop/120000.xlsx"));
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = sheet.getLastRowNum();
		List<Map<String, String>> addressList = new ArrayList<>(rows - 1);
		for (int i = 1; i <= rows; i++) {
			XSSFRow row = sheet.getRow(i);
			String province = row.getCell(8).getStringCellValue();
			String city = row.getCell(9).getStringCellValue();
			String district = row.getCell(10).getStringCellValue();
			String detail = row.getCell(11).getStringCellValue();
			String param = new StringBuilder(province).append(city).append(district).append(detail).toString();

			Map<String, String> map = new HashMap<>();
			map.put("province", province);
			map.put("city", city);
			map.put("district", district);
			map.put("detail", detail);
			map.put("query", param);
			map.put("region", city);
			addressList.add(map);
		}

		// 多线程分批处理
		List<AddressTask> tasks = new ArrayList<>(addressList.size());
		int cpus = Runtime.getRuntime().availableProcessors();
		int size = addressList.size();
		int batch = size % cpus == 0 ? size / cpus : size / cpus + 1;
		for (int i = 0; i < size; i += batch) {
			int end = i + batch;
			if (end > size) {
				end = size;
			}
			List<Map<String, String>> sub = addressList.subList(i, end);
			AddressTask task = new AddressTask(sub, studentService);
			tasks.add(task);
		}

		ExecutorService service = Executors.newFixedThreadPool(cpus);
		List<Future<List<Map<String, String>>>> results = service.invokeAll(tasks);
		List<Map<String, String>> resultList = new ArrayList<>();
		for (Future<List<Map<String, String>>> future : results) {
			List<Map<String, String>> list = future.get();
			resultList.addAll(list);
		}

		addressList.clear();
		// 查询结果填回excle
		for (int i = 0; i < resultList.size(); i++) {
			XSSFRow row = sheet.getRow(i + 1);
			Map<String, String> map = resultList.get(i);
			row.createCell(12).setCellValue(map.get("detail"));
			row.createCell(13).setCellValue(map.get("city"));
			row.createCell(16).setCellValue(map.get("province"));
		}

		wb.write(new FileOutputStream(new File("C:/Users/Administrator/Desktop/333.xlsx")));
		wb.close();
		service.shutdown();

		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
	}
}
