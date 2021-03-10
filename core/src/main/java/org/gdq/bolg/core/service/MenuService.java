package org.gdq.bolg.core.service;

import org.gdq.bolg.core.model.po.MenuPO;
import org.gdq.bolg.core.model.vo.MenuVO;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/9
 * description MenuService
 */
public interface MenuService {
	/**
	 * description 添加菜单
	 *
	 * @param menuPO menuPO
	 * @author gdq date 2020/7/9
	 */
	void addMenu(MenuPO menuPO);

	/**
	 * description 删除菜单
	 *
	 * @param id id
	 * @author gdq date 2020/7/9
	 */
	void removeMenu(String id);

	/**
	 * description 删除菜单
	 *
	 * @param menuVOS 菜单数据
	 * @author gdq date 2020/8/18
	 */
	void removeMenu(List<MenuVO> menuVOS);

	/**
	 * description 修改菜单
	 *
	 * @param menuPO menuPO
	 * @author gdq date 2020/7/9
	 */
	void modifyMenu(MenuPO menuPO);

	/**
	 * description 主键查询菜单
	 *
	 * @param id id
	 * @return MenuPO
	 * @author gdq date 2020/7/9
	 */
	MenuPO queryMenuById(String id);

	/**
	 * description 类型查询菜单
	 *
	 * @param type type
	 * @return List<MenuPO>
	 * @author gdq date 2020/7/9
	 */
	List<MenuPO> queryMenusByType(String type);

	/**
	 * description 查询所有菜单
	 *
	 * @return List<MenuPO>
	 * @author gdq date 2020/7/9
	 */
	List<MenuPO> queryAllMenu();

	List<String> queryAllTypes();
}
