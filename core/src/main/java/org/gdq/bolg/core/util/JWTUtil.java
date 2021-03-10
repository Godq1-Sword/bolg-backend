package org.gdq.bolg.core.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

/**
 * @author God_q1
 * date 2020/7/6
 * description
 */
public class JWTUtil {

	// 签名算法名称
	private static String algorithm;
	// 密钥
	private static String secret;
	// 过期时间
	private static long expiration;
	// 签发人
	private static String iss;

	@Value("${jwt.algorithm}")
	public void setAlgorithm(String algorithm) {
		JWTUtil.algorithm = algorithm;
	}

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		JWTUtil.secret = secret;
	}

	@Value("${jwt.expiration}")
	public void setExpiration(long expiration) {
		JWTUtil.expiration = expiration;
	}

	@Value("${jwt.iss}")
	public void setIss(String iss) {
		JWTUtil.iss = iss;
	}

	/**
	 * description : JWT生成
	 *
	 * @param claims 声明
	 * @return String
	 * @author gdq date 2020/7/6
	 */
	public static String generateJWT(Map<String, Object> claims) {
		// 签名算法
		SignatureAlgorithm signatureAlgorithm = null;
		try {
			signatureAlgorithm = (SignatureAlgorithm) SignatureAlgorithm.class.getField(algorithm).get(SignatureAlgorithm.class);
		} catch (IllegalAccessException | NoSuchFieldException e) {
			e.printStackTrace();
		}
		return Jwts.builder()
				.signWith(signatureAlgorithm, secret)
				.setIssuer(iss)
				.setClaims(claims)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + expiration * 60 * 1000))
				.compact();
	}

	/**
	 * description : 查看身份是否过期
	 *
	 * @param jwt token
	 * @return boolean
	 * @author gdq date 2020/7/6
	 */
	public static boolean isExpiration(String jwt) {
		return parserJwt(jwt).getExpiration().before(new Date());
	}

	/**
	 * description : 解析jwt
	 *
	 * @param jwt token
	 * @return Claims
	 * @throws ExpiredJwtException 解析失败
	 * @author gqd date 2020/7/6
	 */
	public static Claims parserJwt(String jwt) throws ExpiredJwtException {
		return Jwts.parser()
				.setSigningKey(secret)
				.parseClaimsJws(jwt)
				.getBody();
	}
}
