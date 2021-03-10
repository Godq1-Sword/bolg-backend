package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 立方根
 */
public class HJ107 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double num = scanner.nextDouble();
		int flag = 1;
		if (num < 0) {
			num *= -1;
			flag = 0;
		}
		double left = 0;
		double right = num;
		double mid = 0;
		while (right - left >= 0.0001) {
			mid = (right + left) / 2.0;
			if (mid * mid * mid > num) {
				right = mid;
			} else if (mid * mid * mid < num) {
				left = mid;
			} else {
				if (flag == 0) {
					mid *= -1;
				}
				break;
			}
		}
		System.out.printf("%.1f\n", mid);
	}
}
