package org.gdq.bolg.core.model.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author God_q1
 * date 2020/7/14
 * description system_code Table
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodePO {
	// 主键
	private String id;
	// 名称
	private String name;
	// 文本
	private String text;
	// 值
	private String value;
	// 描述
	private String description;
}
