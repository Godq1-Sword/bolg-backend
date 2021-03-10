package org.gdq.bolg.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.gdq.bolg.core.model.po.CodePO;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author God_q1
 * date 2020/7/9
 * description CodeDao
 */
@Repository
@Mapper
public interface CodeDao {

	int insertCode(CodePO itemCode);

	int deleteCode(String id);

	int updateCode(CodePO itemCode);

	List<CodePO> selectAllCode();

	CodePO selectCodeById(String id);

	CodePO selectCodeByName(String name);
}
