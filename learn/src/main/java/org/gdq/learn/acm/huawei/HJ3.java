package org.gdq.learn.acm.huawei;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author gdq
 * date 2020/8/31
 * description 去重,排序
 */
public class HJ3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int count = Integer.parseInt(scanner.next());
			Set<Integer> set = new TreeSet<>();
			for (int i = 0; i < count; i++) {
				int temp = Integer.parseInt(scanner.next());
				set.add(temp);
			}
			for (int i : set){
				System.out.println(i);
			}
		}
	}
}
