package org.demo.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VersionServlet extends HttpServlet {
	private static final long serialVersionUID = -5736059471476094410L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Content-Type", "text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("当前版本：1.0.0");
	}

}
