package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/8/31
 * description 计算字符串中含有的不同字符的个数,多个相同的字符只计算一次
 */
public class HJ10 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			Set<String> set = new HashSet<>();
			for (int i = 0; i < s.length(); i++) {
				set.add(String.valueOf(s.charAt(i)));
			}
			System.out.println(set.size());
		}
	}
}
