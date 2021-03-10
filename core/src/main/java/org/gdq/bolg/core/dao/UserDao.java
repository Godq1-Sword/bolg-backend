package org.gdq.bolg.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.gdq.bolg.core.model.po.UserPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/7
 * description UserDao
 */
@Mapper
@Repository
public interface UserDao {
    UserPO selectUserByUsername(String username);

    List<UserPO> selectUsers();

    int insertUser(UserPO userPO);
}
