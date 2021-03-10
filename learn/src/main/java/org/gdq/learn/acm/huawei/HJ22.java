package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 汽水瓶
 */
public class HJ22 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int i = algo(n);
			System.out.println(i);
		}
	}

	private static int algo(int n) {
		if (n / 3 > 0) {
			return n / 3 + algo(n / 3 + n % 3);
		} else if (n == 2) {
			return 1;
		} else {
			return 0;
		}
	}
}
