package org.demo.jwt.util;

import java.math.BigInteger;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.joda.time.DateTime;

import com.alibaba.fastjson.JSON;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public final class JwtUtils {
	public static final String JWT_ID = UUID.randomUUID().toString();
	public static final String JWT_SECRET = "a7c6ac1209884aa1bd71580df670de53";
	public static final int JWT_TTL = 60 * 60 * 1000; // millisecond

	/**
	 * 由字符串生成加密key
	 *
	 * @return
	 */
	public static SecretKey generalKey() {
		// 本地的密码解码
		byte[] encodedKey = Base64.decodeBase64(JWT_SECRET);
		// 根据给定的字节数组使用AES加密算法构造一个密钥
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
		return key;
	}

	public static String createJWT(String issuer, String subject, long ttlMillis) throws Exception {
		String id = UUID.randomUUID().toString();
		return createJWT(id, issuer, subject, ttlMillis);
	}

	/**
	 * 创建jwt
	 * 
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public static String createJWT(String id, String issuer, String subject, long ttlMillis) throws Exception {

		// 创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
		Map<String, Object> claims = new HashMap<>();
		claims.put("uid", "123456");
		claims.put("user_name", "admin");
		claims.put("nick_name", "X-rapido");

		// 生成签名的时候使用的秘钥secret，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。
		// 一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
		SecretKey key = generalKey();

		// 下面就是在为payload添加各种标准声明和私有声明了
		JwtBuilder builder = Jwts.builder() // 这里其实就是new一个JwtBuilder，设置jwt的body
				.setClaims(claims) // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
				.setId(id) // 设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
				.setAudience("jd.com")// 代表这个JWT的接收对象
				.setIssuedAt(new Date()) // iat: jwt的签发时间
//				.setNotBefore(DateTime.now().plusSeconds(10).toDate())// 代表这个JWT生效的开始时间，意味着在这个时间之前验证JWT是会失败的
				.setExpiration(DateTime.now().plusDays(3).toDate())// jwt过期时间
				.setIssuer(issuer) // issuer：jwt签发人
				.setSubject(subject) // sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
				.signWith(SignatureAlgorithm.HS256, key); // 设置签名使用的签名算法和签名使用的秘钥

		return builder.compact();
	}

	/**
	 * 解密jwt
	 *
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public static Claims parseJWT(String jwt) throws Exception {
		SecretKey key = generalKey(); // 签名秘钥，和生成的签名的秘钥一模一样
		Claims claims = Jwts.parser() // 得到DefaultJwtParser
				.setSigningKey(key) // 设置签名的秘钥
				.parseClaimsJws(jwt).getBody(); // 设置需要解析的jwt
		return claims;
	}

	public static void main(String[] args) {
//		User user = new User(120010L, "ganhaiqiang@aliyun.com", "abc123");
		Map<String, Object> map = new HashMap<>();
		map.put("ad_id", 56);
		map.put("slot_id", 756);
		map.put("user_id", UUID.randomUUID().toString());
		map.put("url",
				"https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9970926603882929394%22%7D&n_type=0&p_from=1");
		map.put("user_id", new Date().getTime());

		String subject = JSON.toJSONString(map);
		System.out.println("subject.length:"+subject.length());

		try {
			SecretKey key = generalKey();
			System.out.println(key.getAlgorithm());
			BigInteger num = new BigInteger(1, key.getEncoded());
			System.out.println("Key: " + num.toString());

			String jwt = JwtUtils.createJWT("eselltech.com", subject, JWT_TTL);
			System.out.println("JWT：" + jwt);
			System.out.println("length：" + jwt.length());

			System.out.println(new String(Base64.decodeBase64(jwt.split("\\.")[0]), "UTF-8"));
			System.out.println(new String(Base64.decodeBase64(jwt.split("\\.")[1]), "UTF-8"));

			System.out.println("\n解密\n");

			Claims c = JwtUtils.parseJWT(jwt);
			System.out.println(JSON.toJSONString(c, true));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
