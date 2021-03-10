package org.gdq.bolg.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.gdq.bolg.core.model.po.MenuPO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author God_q1
 * date 2020/7/16
 * description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
	// id
	private String id;
	// parentId
	private String parentId;
	// 文本
	private String text;
	// 链接
	private String value;
	// 子节点
	private List<MenuVO> children;
	// 种类
	private String type;

	/**
	 * description POS -> VO
	 *
	 * @param menuPOS POS
	 * @author gdq date 2020/7/17
	 */
	public static List<MenuVO> menuPOSToVOS(List<MenuPO> menuPOS) {
		List<MenuVO> menuVOS = new ArrayList<>();
		Map<String, MenuVO> menuVOMap = new HashMap<>();
		List<String> roots = new ArrayList<>();
		// init VOMap,roots
		for (MenuPO menuPO : menuPOS) {
			// new VO
			String menuPOId = menuPO.getId();
			MenuVO menuVO = new MenuVO();
			menuVO.setId(menuPOId);
			menuVO.setParentId(menuPO.getParentId());
			menuVO.setText(menuPO.getText());
			menuVO.setValue(menuPO.getValue());
			menuVO.setChildren(new ArrayList<>());
			menuVO.setType(menuPO.getType());
			boolean hasParent = StringUtils.isNotEmpty(menuPO.getParentId());
			boolean hasValue = StringUtils.isNotEmpty(menuPO.getValue());
			// add root
			if (!hasParent && hasValue) {
				roots.add(0, menuPOId);
			} else if (!hasParent) {
				roots.add(menuPOId);
			}
			menuVOMap.put(menuPO.getId(), menuVO);
		}
		// add children
		for (MenuPO menuPO : menuPOS) {
			String parentId = menuPO.getParentId();
			if (StringUtils.isNotEmpty(parentId)) {
				MenuVO menuVO = menuVOMap.get(parentId);
				menuVO.addChild(menuVOMap.get(menuPO.getId()));
			}
		}
		// add VO
		for (String id : roots) {
			menuVOS.add(menuVOMap.get(id));
		}
		return menuVOS;
	}

	private void addChild(MenuVO menuVO) {
		this.children.add(menuVO);
	}
}
