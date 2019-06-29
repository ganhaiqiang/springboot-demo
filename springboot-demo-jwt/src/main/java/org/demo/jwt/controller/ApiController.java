package org.demo.jwt.controller;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.demo.jwt.model.User;
import org.demo.jwt.util.JwtUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class ApiController {

	@RequestMapping("/login")
	public String login(@RequestBody User user, HttpServletResponse response) throws Exception {

		if (user == null || user.getEmail() == null || user.getPassword() == null) {
			throw new ServletException("Please fill in username and password");
		}

		String email = user.getEmail();
		String password = user.getPassword();

		if (!password.equals("123456")) {
			throw new ServletException("Invalid login. Please check your name and password.");
		}
		Date now=new Date();
		String token = JwtUtils.createJWT("api", JSON.toJSONString(user), 1000L);
		response.addHeader("Authorization", "Bearer " + token);

		return "ok";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
}
