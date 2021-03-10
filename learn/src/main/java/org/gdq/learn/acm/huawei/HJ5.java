package org.gdq.learn.acm.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/31
 * description 写出一个程序,接受一个十六进制的数,输出该数值的十进制表示
 */
public class HJ5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String s = scanner.next();
			BigInteger bigInteger = new BigInteger(s.substring(2), 16);
			System.out.println(bigInteger);
		}
	}
}
