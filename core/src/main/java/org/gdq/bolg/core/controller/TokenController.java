package org.gdq.bolg.core.controller;

import org.gdq.bolg.core.model.po.UserPO;
import org.gdq.bolg.core.model.entity.ReactiveBody;
import org.gdq.bolg.core.service.impl.UserServiceImpl;
import org.gdq.bolg.core.util.JWTUtil;
import org.gdq.bolg.core.util.ReactiveBodyUtil;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gqq
 * date 2020/7/7
 * description
 */
@RestController
@RequestMapping("/token")
public class TokenController {
	// 用户service
	@Resource
	private UserServiceImpl userService;

	/**
	 * description 登录
	 *
	 * @param username 用户名
	 * @param password 密码
	 * @return ResponseBody
	 * @author gdq date 2020/7/7
	 */
	@GetMapping
	public ReactiveBody login(@RequestParam String username, @RequestParam String password) {
		UserPO userPO = (UserPO) userService.loadUserByUsername(username);
		if (!ObjectUtils.isEmpty(userPO) && userPO.getPassword().equals(password)) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("username", username);
			claims.put("password", password);
			return ReactiveBodyUtil.generateSucRB(JWTUtil.generateJWT(claims));
		}
		return ReactiveBodyUtil.generateSucRB(null);
	}
}
