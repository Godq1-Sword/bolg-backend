package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/31
 * description 接受一个正浮点数值,输出该数值的近似整数值
 */
public class HJ7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			double num = Double.parseDouble(scanner.next());
			System.out.println(Math.round(num));
		}
	}
}
