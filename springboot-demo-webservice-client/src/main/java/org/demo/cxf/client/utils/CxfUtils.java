package org.demo.cxf.client.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public final class CxfUtils {
	private CxfUtils() {
	}

	public static Object[] invoke(String wsdl, Object... params) {
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		Client client = dcf.createClient(wsdl);

		client.getInInterceptors().add(new LoggingInInterceptor());

		try {
			return client.invoke("getServerDate", params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ArrayUtils.EMPTY_OBJECT_ARRAY;
	}

	public static Object[] invoke(String wsdl) {
		return invoke(wsdl, ArrayUtils.EMPTY_OBJECT_ARRAY);
	}
}
