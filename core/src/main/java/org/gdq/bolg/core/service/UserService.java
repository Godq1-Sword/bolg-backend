package org.gdq.bolg.core.service;

import org.gdq.bolg.core.model.po.UserPO;

/**
 * @author God_q1
 * date 2020/7/7
 * description UserService
 */
public interface UserService{
	/**
	 * description 插入用户信息
	 *
	 * @param userPO userPO
	 * @return boolean
	 * @author gdq date 2020/7/7
	 */
	boolean insertUser(UserPO userPO);
}
