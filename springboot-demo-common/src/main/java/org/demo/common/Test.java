package org.demo.common;

import org.apache.commons.codec.digest.DigestUtils;

public class Test {
	public static void main(String[] args) {
		System.out.println(DigestUtils.md5Hex("123456"));//"e10adc3949ba59abbe56e057f20f883e"
	}
}
