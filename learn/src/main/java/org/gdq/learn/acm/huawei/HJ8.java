package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/8/31
 * description 数据表记录包含表索引和数值,请对表索引相同的记录进行合并,即将相同索引的数值进行求和运算,输出按照key值升序进行输出。
 */
public class HJ8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			Map<Integer, Integer> map = new HashMap<>();
			int count = Integer.parseInt(scanner.next());
			for (int i = 0; i < count; i++) {
				int key = Integer.parseInt(scanner.next());
				int value = Integer.parseInt(scanner.next());
				int tV = map.get(key) == null ? 0 : map.get(key);
				map.put(key, tV + value);
			}
			Set<Integer> set = new TreeSet<>(map.keySet());
			for (int key : set) {
				int value = map.get(key);
				System.out.println(key + " " + value);
			}
		}
	}
}
