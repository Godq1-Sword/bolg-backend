package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date
 * description
 */
public class Main1Copy {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			String[] temp = s.split(" ");
			int[] a = new int[temp.length];
			for (int i = 0; i < temp.length; i++) {
				a[i] = Integer.parseInt(temp[i]);
			}
			int min = -1;
			if (a.length <= 2) {
				min = 1;
			} else if (a.length == 3 && a[1] == 1) {
				min = 2;
			} else {
				for (int i = 1; i < a.length / 2; i++) {
					// sum 坐标,j 下标,count 步骤
					int sum = i + 1, j = i;
					int count = 1;
					while (sum < a.length) {
						if (j >= a.length) break;
						sum += a[j];
						j += a[j];
						count++;
					}
					if (sum == a.length) {
						if (min == -1 || count < min) {
							min = count;
						}
					}
				}
			}
			System.out.println(min);
		}
	}
}
