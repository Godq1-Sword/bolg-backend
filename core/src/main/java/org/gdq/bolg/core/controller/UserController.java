package org.gdq.bolg.core.controller;

import org.gdq.bolg.core.model.po.UserPO;
import org.gdq.bolg.core.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gdq
 * date 2020/7/7
 * description
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	UserServiceImpl userService;

	@GetMapping
	public boolean String(String username) {
		System.out.println(username);
		UserPO userPO = (UserPO) userService.loadUserByUsername(username);
		System.out.println(userPO);
		return false;
	}
}
