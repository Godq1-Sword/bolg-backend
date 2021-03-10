package org.gdq.learn.sort;

import java.util.*;

/**
 * @author gdq
 * date 2020/9/10
 * description 基数排序
 */
public class RadixSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			radixSort(a);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void radixSort(int[] a) {
		// 最大位数
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		int digit = 0;
		for (int p = 10; max > 0; digit++) {
			max /= p;
		}
		List<List<Integer>> list = new ArrayList<>();
		// 0 ~ 9
		for (int i = 0; i < 10; i++) {
			list.add(new ArrayList<>());
		}
		int div = 1;
		for (int i = 1; i <= digit; i++) {
			div *= 10;
			// 取位数
			for (int k : a) {
				int index = (k % div) / (div / 10);
				list.get(index).add(k);
			}
			int count = 0;
			// 排序,放入a[]
			for (List<Integer> temp : list) {
				if (temp.size() > 0) {
					Collections.sort(temp);
					for (int v : temp) {
						a[count++] = v;
					}
				}
				temp.clear();
			}
		}
	}
}
