package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/31
 * description 计算字符串最后一个单词的长度,单词以空格隔开。
 */
public class HJ1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] strs = str.split("\\s+");
		System.out.println(strs[strs.length - 1].length());
	}
}
