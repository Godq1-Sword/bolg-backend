package org.gdq.bolg.core.model.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author God_q1
 * date 2020/7/7
 * description
 */
@Data
public class ReactiveBody {
	// 错误信息
	private String error;
	// 状态码
	private int status;
	// 消息
	private String message;
	// 数据
	private Object data;
	// 时间
	private Timestamp timestamp;
}
