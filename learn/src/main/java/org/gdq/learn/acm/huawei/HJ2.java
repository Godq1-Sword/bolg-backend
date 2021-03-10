package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/31
 * description 第一行输入一个有字母和数字以及空格组成的字符串,第二行输入一个字符,输出输入字符串中含有该字符的个数
 */
public class HJ2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		String c = scanner.nextLine();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			String temp = String.valueOf(s.charAt(i)).toLowerCase();
			if (c.toLowerCase().equals(temp)) {
				count++;
			}
		}
		System.out.println(count);
	}
}
