package org.gdq.learn.acm.huawei;

import java.util.Collections;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 合唱队  ti <= tn <= tk 最长左序列 - 反转
 */
public class HJ24 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] l = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = scanner.nextInt();
			}
			int[] lc = new int[n];
			int[] dpLeft = new int[n];
			int[] dpRight = new int[n];
			dpLeft[0] = 1;
			for (int i = 1; i < n; i++) {
				int max = 1;
				for (int j = 0; j < i; j++) {
					if (l[i] > l[j]) {
						if (dpLeft[j] + 1 > max) {
							max = dpLeft[j] + 1;
						}
					}
				}
				dpLeft[i] = max;
			}
			// 反转
			for (int i = l.length - 1, j = 0; i >= 0; i--, j++) {
				lc[j] = l[i];
			}
			dpRight[0] = 1;
			for (int i = 1; i < n; i++) {
				int max = 1;
				for (int j = 0; j < i; j++) {
					if (lc[i] > lc[j]) {
						if (dpRight[j] + 1 > max) {
							max = dpRight[j] + 1;
						}
					}
				}
				dpRight[i] = max;
			}
			int max = 0;
			for (int i = 0; i < dpLeft.length; i++) {
				int size = dpLeft[i] + dpRight[n - i - 1] - 1;
				if (size > max) {
					max = size;
				}
			}
			System.out.println(n - max);
		}
	}
}
