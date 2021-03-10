package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 密码 l>8 Aa8$ 2rep
 */
public class HJ20 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			boolean flag;
			int count = 0;
			boolean flagA = false;
			boolean flaga = false;
			boolean flagN = false;
			boolean flagO = false;
			String password = scanner.next();
			if (password.length() <= 8) {
				flag = false;
			} else {
				for (int i = 0; i < password.length(); i++) {
					char c = password.charAt(i);
					if (c >= 'A' && c <= 'Z') {
						if (!flagA) count++;
						flagA = true;
					} else if (c >= 'a' && c <= 'z') {
						if (!flaga) count++;
						flaga = true;
					} else if (c >= '0' && c <= '9') {
						if (!flagN) count++;
						flagN = true;
					} else {
						if (!flagO) count++;
						flagO = true;
					}
				}
				flag = count >= 3;
				if (flag) {
					for (int i = 0; i < password.length() - 2; i++) {
						for (int j = i + 3; j < password.length(); j++) {
							String sub = password.substring(i, j);
							int first = password.indexOf(sub);
							int last = password.lastIndexOf(sub);
							if (last - first > 2) {
								flag = false;
								break;
							}
						}
					}
				}
			}
			System.out.println(flag ? "OK" : "NG");
		}
	}
}