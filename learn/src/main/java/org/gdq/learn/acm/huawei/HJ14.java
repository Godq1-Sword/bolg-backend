package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/8/31
 * description 输出结果为按照字典序排列的字符串
 */
public class HJ14 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = Integer.parseInt(scanner.next());
			List<String> list = new LinkedList<>();
			for (int i = 0; i < num; i++) {
				list.add(scanner.next());
			}
			Collections.sort(list);
			for (String temp : list) {
				System.out.println(temp);
			}
		}
	}
}
