package org.gdq.learn.sort;

import java.util.*;

/**
 * @author gdq
 * date 2020/9/9
 * description 桶排序
 */
public class BucketSort {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = scanner.nextInt();
			}
			bucketSort(a);
			System.out.println(Arrays.toString(a));
		}
	}

	private static void bucketSort(int[] a) {
		// 5桶
		int min = a[0], max = a[0], n = 5;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
			if (a[i] < min) {
				min = a[i];
			}
		}
		List<List<Integer>> bucket = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			bucket.add(new ArrayList<>());
		}
		// 区间映射
		double space = (max - min) * 1.0 / n;
		for (int i = 0; i < a.length; i++) {
			double indexDb = Math.ceil((a[i] - min) * 1.0 / space);
			int index = (int) (indexDb > 0 ? indexDb - 1 : indexDb);
			bucket.get(index).add(a[i]);
		}
		for (int i = 0, j = 0; i < n; i++) {
			Collections.sort(bucket.get(i));
			for (int value : bucket.get(i)) {
				a[j++] = value;
			}
		}
	}
}