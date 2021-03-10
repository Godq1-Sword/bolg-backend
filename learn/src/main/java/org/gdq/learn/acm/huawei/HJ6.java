package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/31
 * description 输入一个正整数,按照从小到大的顺序输出它的所有质因子
 */
public class HJ6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int num = Integer.parseInt(scanner.next());
			for (int i = 2; i <= num; ) {
				if (num % i == 0) {
					num /= i;
					System.out.print(i + " ");
					i = 2;
				} else {
					i++;
				}
			}
			System.out.println();
		}
	}
}
