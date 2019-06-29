package demo1.test;

import org.demo.multidatasource.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Demo1Test {

//	@Autowired
//	private StudentMapper studentMapper;
//
//	@Autowired
//	private ProductMapper productMapper;
//
//	@Test
//	public void test() {
//		Student student = studentMapper.selectByPrimaryKey(33);
//		Product product = productMapper.selectByPrimaryKey(3);
//		System.out.println(JSON.toJSONString(student, true));
//		System.out.println(JSON.toJSONString(product, true));
//	}
}
