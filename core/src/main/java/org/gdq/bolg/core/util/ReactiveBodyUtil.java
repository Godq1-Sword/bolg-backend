package org.gdq.bolg.core.util;

import org.gdq.bolg.core.model.entity.ReactiveBody;

import java.sql.Timestamp;

/**
 * @author God_q1
 * date 2020/7/7
 * description 响应数据工具
 */
public class ReactiveBodyUtil {

	// 状态 - 成功请求
	public static final int STATUS_SUC = 200;
	// 状态 - 失败请求
	public static final int STATUS_ERR = 500;
	// 状态 - 权限不足
	public static final int STATUS_SEC = 403;

	// 500 - 错误信息
	private static final String MESSAGE_500 = "服务器错误";
	// 403 - 错误信息
	private static final String MESSAGE_403 = "权限不足";

	/**
	 * description : 生产响应数据
	 *
	 * @param data    响应数据
	 * @param error   失败信息
	 * @param message 详细信息
	 * @param status  状态值
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	private static ReactiveBody generateCommRB(Object data, String error, String message, int status) {
		ReactiveBody responseBody = new ReactiveBody();
		responseBody.setData(data);
		responseBody.setError(error);
		responseBody.setMessage(message);
		responseBody.setStatus(status);
		responseBody.setTimestamp(new Timestamp(System.currentTimeMillis()));
		return responseBody;
	}

	/**
	 * description : 默认成功响应
	 *
	 * @param data 响应数据
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateSucRB(Object data) {
		return generateCommRB(data, null, null, STATUS_SUC);
	}

	/**
	 * description : 默认带消息成功响应
	 *
	 * @param data 响应数据
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateSucRB(Object data, String message) {
		return generateCommRB(data, null, message, STATUS_SUC);
	}

	/**
	 * description : 默认错误响应
	 *
	 * @param error 失败信息
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateErrRB(String error) {
		return generateCommRB(null, error, MESSAGE_500, STATUS_ERR);
	}

	/**
	 * description : 自定错误响应
	 *
	 * @param error   失败信息
	 * @param message 详细信息
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateErrRB(String error, String message) {
		return generateCommRB(null, error, message, STATUS_ERR);
	}

	/**
	 * description : 默认权限不足响应
	 *
	 * @param error 失败信息
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateSecRB(String error) {
		return generateCommRB(null, error, MESSAGE_403, STATUS_SEC);
	}

	/**
	 * description : 自定权限不足响应
	 *
	 * @param error   失败信息
	 * @param message 详细信息
	 * @return ReactiveBody
	 * @author gdq date 2020/7/7
	 */
	public static ReactiveBody generateSecRB(String error, String message) {
		return generateCommRB(null, error, message, STATUS_SEC);
	}
}
