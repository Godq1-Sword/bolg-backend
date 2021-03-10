package org.gdq.bolg.core.service;

import org.gdq.bolg.core.model.po.CodePO;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/16
 * description CodeService
 */
public interface CodeService {

	/**
	 * description 添加代码项
	 *
	 * @param codePO codePO
	 * @return boolean
	 * @author gdq date 2020/7/16
	 */
	boolean addCode(CodePO codePO);

	/**
	 * description 删除代码项
	 *
	 * @param id id
	 * @return boolean
	 * @author gdq date 2020/7/16
	 */
	boolean removeCode(String id);

	/**
	 * description 修改代码项
	 *
	 * @param codePO codePO
	 * @return boolean
	 * @author gdq date 2020/7/16
	 */
	boolean modifyCode(CodePO codePO);

	/**
	 * description 主键查询代码项
	 *
	 * @param id id
	 * @return CodePO
	 * @author gdq date 2020/7/16
	 */
	CodePO queryCodeById(String id);

	/**
	 * description 名称查询代码项
	 *
	 * @param name name
	 * @return CodePO
	 * @author gdq date 2020/7/16
	 */
	CodePO queryCodeByName(String name);

	/**
	 * description 查询所有代码项
	 *
	 * @return boolean
	 * @author gdq date 2020/7/16
	 */
	List<CodePO> queryAllCode();
}
