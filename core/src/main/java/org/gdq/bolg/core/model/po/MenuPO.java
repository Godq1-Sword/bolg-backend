package org.gdq.bolg.core.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gdq.bolg.core.model.vo.MenuVO;

/**
 * @author God_q1
 * date 2020/7/8
 * description menu_item Table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuPO {
	// 主键
	private String id;
	// 父键
	private String parentId;
	// 种类
	private String type;
	// 文本
	private String text;
	// 值
	private String value;

	/**
	 * description MenuVO To MenuPO
	 *
	 * @param menuVO menuVO
	 * @author gdq date 2020/8/14
	 */
	public MenuPO(MenuVO menuVO) {
		this.setId(menuVO.getId());
		this.setType(menuVO.getType());
		this.setParentId(menuVO.getParentId());
		this.setText(menuVO.getText());
		this.setValue(menuVO.getValue());
	}
}
