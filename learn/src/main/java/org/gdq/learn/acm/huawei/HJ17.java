package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description 坐标移动
 */
public class HJ17 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			String[] data = s.split(";");
			int x = 0;
			int y = 0;
			for (String index : data) {
				if (!"".equals(index) && index != null) {
					char c = index.charAt(0);
					String temp = index.substring(1);
					try {
						int mv = Integer.parseInt(temp);
						switch (c) {
							case 'A':
								x -= mv;
								break;
							case 'D':
								x += mv;
								break;
							case 'W':
								y += mv;
								break;
							case 'S':
								y -= mv;
								break;
						}
					} catch (Exception ignored) {
					}
				}
			}
			System.out.println(x + "," + y);
		}
	}
}
