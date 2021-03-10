package org.gdq.bolg.core.service.impl;

import org.gdq.bolg.core.dao.CodeDao;
import org.gdq.bolg.core.model.po.CodePO;
import org.gdq.bolg.core.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author God_q1
 * date 2020/7/16
 * description
 */
@Service
public class CodeServiceImpl implements CodeService {

	@Resource
	private CodeDao codeDao;

	@Override
	public boolean addCode(CodePO codePO) {
		return codeDao.insertCode(codePO) > 0;
	}

	@Override
	public boolean removeCode(String id) {
		return codeDao.deleteCode(id) > 0;
	}

	@Override
	public boolean modifyCode(CodePO codePO) {
		return codeDao.updateCode(codePO) > 0;
	}

	@Override
	public CodePO queryCodeById(String id) {
		return codeDao.selectCodeById(id);
	}

	@Override
	public CodePO queryCodeByName(String name) {
		return codeDao.selectCodeByName(name);
	}

	@Override
	public List<CodePO> queryAllCode() {
		return codeDao.selectAllCode();
	}
}
