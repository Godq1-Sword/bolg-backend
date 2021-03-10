package org.gdq.learn.acm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author gdq
 * date
 * description
 */
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String[] tempArray = str.split(",");
		List<List<Integer>> list = new ArrayList<>();
	}

	private static int getList(List<List<Integer>> list) {
		List<List<Integer>> nodes = new ArrayList<>();
		for (List<Integer> tempNode : list) {
			List<Integer> node = new ArrayList<>();
			int sum = 0;
			for (int i : tempNode) {
				node.add(sum += i);
			}
			nodes.add(node);
		}
		int length = nodes.get(0).size();
		int min = -1;
		for (int i = 1; i < length; i++) {
			int count = 0;
			for (List<Integer> node : nodes) {
				if (node.contains(i)) {
					count++;
				}
			}
			if (min < count) {
				min = count;
			}
		}
		return min;
	}
}