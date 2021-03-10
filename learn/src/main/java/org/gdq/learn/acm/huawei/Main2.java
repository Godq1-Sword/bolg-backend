package org.gdq.learn.acm.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author gdq
 * date
 * description
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			if (!"".equals(s.trim()) && s.length() <= 2) {
				System.out.println(0);
			} else {
				s = s.substring(1, s.length() - 1);
				String[] temp = s.split(",");
				if (temp.length > 0) {
					int[] a = new int[temp.length];
					Map<Integer, Integer> map = new HashMap<>();
					int max = -1;
					for (int i = 0; i < temp.length; i++) {
						a[i] = Integer.parseInt(temp[i]);
						if (a[i] > max) {
							max = a[i];
						}
						map.put(a[i], -1);
					}
					boolean flag = false;
					for (int i = 0; i <= a.length; i++) {
						if (map.get(i) == null) {
							flag = true;
							System.out.println(i);
							break;
						}
					}
					if (!flag)
						System.out.println(max + 1);
				}
			}
		}
	}
}
