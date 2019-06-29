package org.demo.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.jwt.util.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String authHeader = request.getHeader("Authorization");
		String uri = request.getRequestURI();

		if ("OPTIONS".equals(request.getMethod()) || "/login".equals(uri)) {
			response.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(req, res);
		} else {
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing or invalid Authorization header");
//				throw new ServletException("Missing or invalid Authorization header");
				return;
			}

			String token = authHeader.substring(7);

			try {
				Claims claims = JwtUtils.parseJWT(token);
				request.setAttribute("claims", claims);
				LOGGER.info("claims={}", JSON.toJSONString(claims, true));
			} catch (SignatureException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token");
//				throw new ServletException("Invalid token");
			} catch (ExpiredJwtException e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "token expired");
//				throw new ServletException("token expired");
			} catch (Exception e) {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "JWT error");
//				throw new ServletException("JWT error");
			}

			chain.doFilter(req, res);
		}
	}

}
