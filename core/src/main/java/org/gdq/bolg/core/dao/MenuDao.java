package org.gdq.bolg.core.dao;

import org.apache.ibatis.annotations.Mapper;
import org.gdq.bolg.core.model.po.MenuPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author God_q1
 * date 2020/7/9
 * description MenuDao
 */
@Repository
@Mapper
public interface MenuDao {
	/**
	 * description 插入菜单
	 *
	 * @return int
	 * @author gdq date 2020/8/13
	 */
	int insertMenu(MenuPO menuPO);

	int deleteMenu(String id);

	/**
	 * description 更新菜单
	 *
	 * @param menuPO menuPO
	 * @return int
	 * @author gdq date 2020/8/13
	 */
	int updateMenu(MenuPO menuPO);

	List<MenuPO> selectAllMenu();

	MenuPO selectMenuById(String id);

	List<MenuPO> selectMenusByType(String type);

	List<String> selectAllType();
}
