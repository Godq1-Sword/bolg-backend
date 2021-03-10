package org.gdq.learn.sort;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/2
 * description 选择排序
 */
public class SelectSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			selectSort(a);
			for (int j : a) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private static void selectSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = a[i], index = 0;
			boolean flag = false;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i] && a[j] < min) {
					min = a[j];
					index = j;
					flag = true;
				}
			}
			// 有最小值,交换
			if (flag) {
				a[index] = a[i];
				a[i] = min;
			}
		}
	}
}
