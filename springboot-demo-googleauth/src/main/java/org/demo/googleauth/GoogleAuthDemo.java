package org.demo.googleauth;

import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;

public class GoogleAuthDemo {
	public static void main(String[] args) {
		// 用户注册时使用
		// 获取一个新的密钥，默认16位，该密钥与用户绑定
		GoogleAuthenticator gAuth = new GoogleAuthenticator();
		final GoogleAuthenticatorKey key = gAuth.createCredentials();
		String key1 = key.getKey();
		System.out.println(key1);

		// 用户登录时使用
		// 根据用户密钥和用户输入的密码，验证是否一致。（近3个密码都有效：前一个，当前，下一个）
		boolean isCodeValid = gAuth.authorize("Q2A7TDC2NGKMKJXI", 184380);
		System.out.println(isCodeValid);

		// 根据密钥，获取最新密码（后台用不到，用来开发 谷歌身份验证器 客户端）
		int code = gAuth.getTotpPassword("Q2A7TDC2NGKMKJXI");
		System.out.println(code);
	}
}
