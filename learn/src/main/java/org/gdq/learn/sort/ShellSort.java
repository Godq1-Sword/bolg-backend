package org.gdq.learn.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/8
 * description 希尔排序
 */
public class ShellSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			shellSort(a);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void shellSort(int[] a) {
		// 增量初始化 length/2 -> 1
		for (int step = a.length / 2; step > 0; step /= 2) {
			// 直插
			for (int i = step; i < a.length; i += step) {
				// 后移
				if (i - step >= 0 && a[i] < a[i - step]) {
					int j = i - step, temp = a[i];
					for (; j >= 0 && temp < a[j]; j -= step) {
						a[j + step] = a[j];
					}
					a[j + step] = temp;
				}
			}
		}
	}
}