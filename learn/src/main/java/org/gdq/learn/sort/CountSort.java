package org.gdq.learn.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author gdq
 * date
 * description
 */
public class CountSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			countSort(a);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void countSort(int[] a) {
		int min = a[0], max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}
		int[] count = new int[max - min + 1];
		for (int j : a) {
			count[j - min]++;
		}
		for (int i = min, j = 0; i <= max; i++) {
			while (count[i - min] != 0) {
				a[j++] = i;
				count[i - min]--;
			}
		}
	}
}
