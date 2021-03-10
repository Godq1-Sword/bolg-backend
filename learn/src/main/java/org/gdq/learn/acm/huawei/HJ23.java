package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/9/1
 * description 删除字符
 */
public class HJ23 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			Map<String, Integer> map = new LinkedHashMap<>();
			List<String> list = new ArrayList<>();
			int min = 1;
			for (int i = 0; i < s.length(); i++) {
				String charStr = String.valueOf(s.charAt(i));
				Integer n = map.get(charStr);
				if (n == null) {
					n = 1;
				} else {
					n++;
				}
				if (n <= min) {
					list.add(charStr);
					min = n;
				} else {
					list.remove(charStr);
				}
				map.put(charStr, n);
			}
			for (int i = 0; i < s.length(); i++) {
				String charStr = String.valueOf(s.charAt(i));
				if (!list.contains(charStr)) {
					System.out.print(charStr);
				}
			}
			System.out.println();
		}
	}
}
