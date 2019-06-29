package org.demo.web.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public final class MacUtils {

	private MacUtils() {
	}

	public static String getLocalMac() throws SocketException, UnknownHostException {
		InetAddress inetAddress = InetAddress.getLocalHost();
		byte[] mac = NetworkInterface.getByInetAddress(inetAddress).getHardwareAddress();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}
		return sb.toString().trim().toUpperCase();
	}

	public static void main(String[] args) throws Exception {
		System.out.println(getLocalMac());
	}
}
