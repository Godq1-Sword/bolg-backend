package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date
 * description
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			// 菜数
			int n = scanner.nextInt();
			// 手速
			int m = scanner.nextInt();
			// 合适时间
			int[] time = new int[n];
			for (int i = 0; i < n; i++) {
				time[i] = scanner.nextInt() + scanner.nextInt();
			}
			for (int i = 0; i < time.length - 1; i++) {
				for (int j = 0; j < time.length - 1 - i; j++) {
					if (time[j + 1] > time[j]) {
						int t = time[j];
						time[j] = time[j + 1];
						time[j + 1] = t;
					}
				}
			}
			int count = 1;
			int readyTime = time[0] + m;
			for (int i = 1; i < n; i++) {
				if (time[i] >= readyTime) {
					readyTime += m;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}