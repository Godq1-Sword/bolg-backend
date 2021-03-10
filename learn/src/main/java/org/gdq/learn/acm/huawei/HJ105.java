package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 统计非负数
 */
public class HJ105 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 0, j = 0, sum = 0;
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			if (n > 0) {
				sum += n;
				j++;
			} else {
				i++;
			}
		}
		System.out.println(i);
		System.out.printf("%.1f", 1.0 * sum / j);
	}
}
