package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/8/3
 * description 输入一个int型的正整数,计算出该int型数据在内存中存储时1的个数
 */
public class HJ16 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money = scanner.nextInt();
		int total = scanner.nextInt();
		// 临时数据
		int[][] tempData = new int[total + 1][7];
		int count = 1;
		for (int i = 1; i <= total; i++) {
			// money
			int v = scanner.nextInt();
			// weight math
			int p = scanner.nextInt();
			// relation
			int q = scanner.nextInt();
			if (q != 0) {
				int index = tempData[q][1] == 0 ? 1 : 2;
				tempData[q][index] = v;
				tempData[q][index == 1 ? 5 : 6] = v * p;
			} else {
				count++;
				tempData[i][q] = v;
				tempData[i][4] = v * p;
			}
		}
		int[][] price = new int[count][3];
		int[][] weight = new int[count][3];
		// 整理数据
		int j = 1;
		for (int i = 1; i < tempData.length; i++) {
			if (tempData[i][0] != 0) {
				price[j][0] = tempData[i][0];
				price[j][1] = tempData[i][1];
				price[j][2] = tempData[i][2];
				weight[j][0] = tempData[i][4];
				weight[j][1] = tempData[i][5];
				weight[j++][2] = tempData[i][6];
			}
		}
		// 背包
		int[][] kns = new int[count][money + 1];
		for (int i = 1; i < count; i++) {
			for (j = 1; j <= money; j++) {
				// 加入背包
				if (j - price[i][0] >= 0) {
					// 主件
					int maxM1 = 0;
					int maxM2 = 0;
					int maxM12 = 0;
					int maxM0 = Math.max(kns[i - 1][j - price[i][0]] + weight[i][0], kns[i - 1][j]);
					// 加选附件1
					if (j - price[i][0] - price[i][1] >= 0) {
						maxM1 = Math.max(kns[i - 1][j - price[i][0] - price[i][1]] + weight[i][0] + weight[i][1], kns[i - 1][j]);
					}
					// 加选附件2
					if (j - price[i][0] - price[i][2] >= 0) {
						maxM2 = Math.max(kns[i - 1][j - price[i][0] - price[i][2]] + weight[i][0] + weight[i][2], kns[i - 1][j]);
					}
					// 加选附件12
					if (j - price[i][0] - price[i][1] - price[i][2] >= 0) {
						maxM12 = Math.max(kns[i - 1][j - price[i][0] - price[i][1] - price[i][2]] + weight[i][0] + weight[i][1] + weight[i][2], kns[i - 1][j]);
					}
					// 最大值
					kns[i][j] = Math.max(Math.max(maxM0, maxM1), Math.max(maxM2, maxM12));
				} else {
					// 不加入背包
					kns[i][j] = kns[i - 1][j];
				}
			}
		}
		System.out.println(kns[count - 1][money]);
	}
}
