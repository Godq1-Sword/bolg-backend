package org.gdq.learn.acm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/3
 * description n 皇后
 */
public class LeetCode51NQueens {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int n = scanner.nextInt();
			List<List<String>> queens = solveNQueens(n);
			System.out.println(queens);
		}

	}

	private static List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		int[] pos = new int[n];
		Arrays.fill(pos, -1);
		backTrack(n, 0, pos, res);
		return res;
	}

	private static void backTrack(int n, int row, int[] pos, List<List<String>> res) {
		// 棋盘放满
		int length;
		for (length = 0; length < pos.length; length++) {
			if (pos[length] == -1) break;
		}
		if (length == pos.length) {
			List<String> aRes = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				StringBuilder aSub = new StringBuilder();
				for (int j = 0; j < n; j++) {
					if (j != pos[i]) {
						aSub.append(".");
					} else {
						aSub.append("Q");
					}
				}
				aRes.add(aSub.toString());
			}
			res.add(aRes);
		}
		// y
		for (int i = 0; i < n; i++) {
			if (isValid(pos, i, row)) {
				pos[row] = i;
				backTrack(n, row + 1, pos, res);
				// 回溯
				pos[row] = -1;
			}
		}
	}

	private static boolean isValid(int[] pos, int index, int row) {
		for (int i = 0; i < pos.length; i++) {
			if (pos[i] != -1 && (pos[i] == index || index + row == i + pos[i] || i - pos[i] == row - index)) {
				return false;
			}
		}
		return true;
	}
}
