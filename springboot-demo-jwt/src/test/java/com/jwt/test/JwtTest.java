package com.jwt.test;

import org.demo.jwt.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class JwtTest {

	@Test
	public void encoderTest() {
	}

	@Test
	public void decoderTest() {
	}
}
