package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 最小公倍数
 */
public class HJ108 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		for (int i = Math.max(a, b); i <= a * b; i++) {
			if (i % a == 0 && i % b == 0) {
				System.out.println(i);
				return;
			}
		}
	}
}
