package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 简单密码
 */
public class HJ21 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			char[] copy = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c >= 'a' && c <= 'z') {
					toChange(c, i, copy);
				} else if (c >= 'A' && c <= 'Z') {
					c += 32;
					if (c == 'z') c = 'a';
					else c++;
					copy[i] = c;
				} else {
					copy[i] = c;
				}
			}
			System.out.println(copy);
		}
	}

	public static void toChange(char c, int i, char[] copy) {
		switch (c) {
			case 'a':
			case 'b':
			case 'c':
				copy[i] = '2';
				break;
			case 'd':
			case 'e':
			case 'f':
				copy[i] = '3';
				break;
			case 'g':
			case 'h':
			case 'i':
				copy[i] = '4';
				break;
			case 'j':
			case 'k':
			case 'l':
				copy[i] = '5';
				break;
			case 'm':
			case 'n':
			case 'o':
				copy[i] = '6';
				break;
			case 'p':
			case 'q':
			case 'r':
			case 's':
				copy[i] = '7';
				break;
			case 't':
			case 'u':
			case 'v':
				copy[i] = '8';
				break;
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				copy[i] = '9';
				break;
		}
	}
}
