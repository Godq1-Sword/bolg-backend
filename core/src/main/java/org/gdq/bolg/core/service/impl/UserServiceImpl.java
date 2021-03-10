package org.gdq.bolg.core.service.impl;

import org.gdq.bolg.core.dao.UserDao;
import org.gdq.bolg.core.model.po.UserPO;
import org.gdq.bolg.core.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author God_q1
 * date 2020/7/7
 * description
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Resource
	private UserDao userDao;

	@Override
	public boolean insertUser(UserPO userPO) {
		return userDao.insertUser(userPO) > 0;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.selectUserByUsername(username);
	}
}
