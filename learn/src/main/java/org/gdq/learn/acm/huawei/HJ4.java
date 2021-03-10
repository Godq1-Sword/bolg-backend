package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 字符串分割
 */
public class HJ4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			int count = s.length() / 8;
			count = s.length() % 8 == 0 ? count : count + 1;
			for (int i = 0; i < count; i++) {
				int minus = 8 * count - s.length();
				int rightKey = i == count - 1 ? (i + 1) * 8 - minus : (i + 1) * 8;
				String temp = s.substring(i * 8, rightKey);
				if (temp.length() < 8) {
					int miuLength = 8 - temp.length();
					System.out.print(temp);
					for (int tI = 0; tI < miuLength; tI++) {
						if (tI == miuLength - 1) {
							System.out.println(0);
						} else {
							System.out.print(0);
						}
					}
				} else {
					System.out.println(temp);
				}
			}
		}
	}
}
