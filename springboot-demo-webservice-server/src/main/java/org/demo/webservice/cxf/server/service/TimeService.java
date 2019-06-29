package org.demo.webservice.cxf.server.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.server.cxf.webservice.demo.org")
public interface TimeService {

	@WebMethod
	String getServerDate();
}
