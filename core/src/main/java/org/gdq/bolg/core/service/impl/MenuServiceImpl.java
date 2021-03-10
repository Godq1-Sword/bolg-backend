package org.gdq.bolg.core.service.impl;

import org.gdq.bolg.core.dao.MenuDao;
import org.gdq.bolg.core.model.po.MenuPO;
import org.gdq.bolg.core.model.vo.MenuVO;
import org.gdq.bolg.core.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author God_q1
 * date 2020/7/9
 * description
 */
@Service
public class MenuServiceImpl implements MenuService {
	@Resource
	private MenuDao menuDao;

	@Override
	public void addMenu(MenuPO menuPO) {
		menuDao.insertMenu(menuPO);
	}

	@Override
	public void removeMenu(String id) {
		menuDao.deleteMenu(id);
	}

	@Override
	public void removeMenu(List<MenuVO> menuVOS) {
		Set<String> ids = new HashSet<>();
		menuVOS.forEach(item -> removeChildren(item, ids));
		for (String id : ids) {
			removeMenu(id);
		}
	}

	@Override
	public void modifyMenu(MenuPO menuPO) {
		menuDao.updateMenu(menuPO);
	}

	@Override
	public MenuPO queryMenuById(String id) {
		return menuDao.selectMenuById(id);
	}

	@Override
	public List<MenuPO> queryMenusByType(String type) {
		return menuDao.selectMenusByType(type);
	}

	@Override
	public List<MenuPO> queryAllMenu() {
		return menuDao.selectAllMenu();
	}

	@Override
	public List<String> queryAllTypes() {
		return menuDao.selectAllType();
	}

	/**
	 * description 递归删除子节点
	 *
	 * @param menuVO 菜单
	 * @author gdq date 2020/8/18
	 */
	private void removeChildren(MenuVO menuVO, Set<String> ids) {
		List<MenuVO> children = menuVO.getChildren();
		if (!ObjectUtils.isEmpty(children)) {
			children.forEach(item -> removeChildren(item, ids));
		} else {
			ids.add(menuVO.getId());
		}
	}
}
