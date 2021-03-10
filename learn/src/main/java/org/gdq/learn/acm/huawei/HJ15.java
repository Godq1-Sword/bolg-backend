package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/3
 * description 输入一个int型的正整数,计算出该int型数据在内存中存储时1的个数
 */
public class HJ15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = Integer.parseInt(scanner.next());
			int count;
			for (count = 0; num > 0; num >>= 1) {
				count += num & 1;
			}
			System.out.println(count);
		}
	}
}
