package org.demo.markdown.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.demo.markdown.entity.Blog;
import org.demo.markdown.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainController {

	private static String UPLOADED_FOLDER = "D:\\images\\";
	@Autowired
	BlogRepository blogRepository;

	@RequestMapping("edit")
	public String Hello() {
		return "edit";
	}

	@RequestMapping("submit")
	@ResponseBody
	public void submit(Blog blog) {
		System.out.println(blog.getContent());
		System.out.println(blog.getHtmlContent());
		blogRepository.save(blog);
	}

	@RequestMapping("view")
	public String view(Long id, Model model) {
		Blog blog = blogRepository.findBlogById(id);
		System.out.println(blog.getHtmlContent());
		model.addAttribute("blog", blog);
		return "view";
	}

	// 处理文件上传
	@RequestMapping(value = "/uploadimg")
	public @ResponseBody Map<String, Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		System.out.println(request.getContextPath());
		// String realPath = UPLOADED_FOLDER;
		String fileName = file.getOriginalFilename();
		System.out.println(fileName);
		try {
			// file.transferTo(targetFile);
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			resultMap.put("success", 1);
			resultMap.put("message", "上传成功！");
			resultMap.put("url", "../images/" + fileName);
		} catch (Exception e) {
			resultMap.put("success", 0);
			resultMap.put("message", "上传失败！");
			e.printStackTrace();
		}
		System.out.println(resultMap.get("success"));
		return resultMap;

	}
}
