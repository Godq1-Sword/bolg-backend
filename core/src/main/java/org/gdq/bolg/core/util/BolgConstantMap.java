package org.gdq.bolg.core.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gdq
 * date 2020/8/11
 * description 常量Map
 */
public class BolgConstantMap {
	private static final Map<String, Object> constantMap = new HashMap<>();

	static {
		constantMap.put("navbar", "NavBar - 侧栏菜单");
		constantMap.put("setting", "Setting - 设定菜单");
	}

	// 单例
	private BolgConstantMap() {
	}

	public static Object getValue(String key) {
		return constantMap.get(key);
	}
}
