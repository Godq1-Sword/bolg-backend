package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/3
 * description 输入一个整数,将这个整数以字符串的形式逆序输出
 */
public class HJ106 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			for (int i = s.length() - 1; i >= 0; i--) {
				System.out.print(s.charAt(i));
			}
		}
	}
}
