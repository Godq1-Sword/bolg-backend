package org.gdq.bolg.core.config;

import org.gdq.bolg.core.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * program : taxoa-backend
 * description: Spring Security 配置类
 *
 * @author : gdq
 * data : 2019-11-19 16:05
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 用户信息Service
	@Resource
	private UserServiceImpl userDetailsService;

	// 密码编码
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * description : Security配置
	 *
	 * @param http:请求
	 * @author : gdq
	 * data : 2020/1/3 0003 18:46
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().ignoringAntMatchers("/**");
		// 跨域
//		http.oauth2Login().and()
//				.csrf()
//				.disable()
//				.authorizeRequests()
//				// 公开页面
//				.antMatchers("/token", "/file/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				// 关闭Session
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//				.and()
//				// 权限过滤
//				.addFilter(new AuthorizationFilter(authenticationManager()));
//		http.authorizeRequests()
//				.anyRequest().authenticated().and().csrf().ignoringAntMatchers("/druid");
//				.and()
		// oauth2 client
//				.oauth2Login();
//				.oauth2Client(oauth2 -> oauth2
//						.clientRegistrationRepository(this.clientRegistrationRepository())
//						.authorizedClientRepository(this.authorizedClientRepository())
//						.authorizedClientService(this.authorizedClientService())
//						.authorizationCodeGrant(codeGrant -> codeGrant
//								.authorizationRequestRepository(this.authorizationRequestRepository())
//								.authorizationRequestResolver(this.authorizationRequestResolver())
//								.accessTokenResponseClient(this.accessTokenResponseClient())
//						)
//				);
//				.oauth2ResourceServer()
//				.jwt();
	}

	/**
	 * description : 加密密码
	 *
	 * @param auth:用户信息
	 * @author : gdq
	 * data : 2020/1/3 0003 18:47
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
