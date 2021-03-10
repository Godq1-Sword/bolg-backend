package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/3
 * description 输入一个整数,将这个整数以字符串的形式逆序输出
 */
public class HJ11Or12 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			for (int i = s.length() - 1; i >= 0; i--) {
				System.out.print(s.charAt(i));
			}
		}
	}
}
