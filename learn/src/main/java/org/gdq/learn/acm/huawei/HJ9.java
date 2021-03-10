package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/8/31
 * description 输入一个int型整数,按照从右向左的阅读顺序,返回一个不含重复数字的新的整数
 */
public class HJ9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			Set<Integer> set = new LinkedHashSet<>();
			for (int i = s.length() - 1; i >= 0; i--) {
				set.add(Integer.parseInt(String.valueOf(s.charAt(i))));
			}
			for (int i : set) {
				System.out.print(i);
			}
		}
	}
}
