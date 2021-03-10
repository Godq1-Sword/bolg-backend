package org.gdq.bolg.core.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.gdq.bolg.core.service.impl.UserServiceImpl;
import org.gdq.bolg.core.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * @author gdq
 * date 2020/7/7
 * description 权限拦截
 */
public class AuthorizationFilter extends BasicAuthenticationFilter {

	@Override
	protected void initFilterBean() throws ServletException {
		super.initFilterBean();
	}

	@Resource
	private UserServiceImpl userService;

	public AuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	/**
	 * description 拦截请求
	 *
	 * @param request:http请求体
	 * @param response:http响应体
	 * @param chain:处理链
	 * @author : gdq
	 * data : 2020/1/3 0003 18:20
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO:Redis缓存Token
//		if ("/token".equals(request.getRequestURI())) {
//			chain.doFilter(request, response);
//			return;
//		}
		// 请求头token
		String token = request.getHeader("Authorization");
		if (StringUtils.isEmpty(token)) {
			chain.doFilter(request, response);
			return;
		}
		// SpringSecurity存值
		SecurityContextHolder.getContext().setAuthentication(getAuthentication(token));
		chain.doFilter(request, response);
	}

	/**
	 * description : 验证身份
	 *
	 * @param token:信息令牌
	 * @return UsernamePasswordAuthenticationToken
	 * @author : gdq
	 * data : 2020/1/3 0003 18:21
	 */
	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		if (!StringUtils.isEmpty(token)) {
			Claims claims = null;
			try {
				claims = JWTUtil.parserJwt(token);
			} catch (ExpiredJwtException e) {
				logger.info("身份过期");
			}
			if (!ObjectUtils.isEmpty(claims)) {
				System.out.println(userService);
				return new UsernamePasswordAuthenticationToken(null, null, null);
//				return new UsernamePasswordAuthenticationToken(userPO, userPO.getPassword(), userPO.getAuthorities());
			}
		}
		return null;
	}
}
