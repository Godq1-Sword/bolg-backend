package org.gdq.learn.acm.huawei;

import java.util.*;

/**
 * @author gdq
 * date 2020/9/1
 * description 记录错误
 */
public class HJ19 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> list = new LinkedList<>();
		Map<String, String> map = new HashMap<>();
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			String[] temp = s.split("\\s+");
			String[] path = temp[0].split("\\\\");
			String file = path[path.length - 1];
			if (file.length() > 16)
				file = file.substring(file.length() - 16);
			String key = map.get(file + " " + temp[1]);
			if (key == null) {
					key = "1";
				list.add(file + " " + temp[1]);
			} else {
				key = String.valueOf(Integer.parseInt(key) + 1);
			}
			map.put(file + " " + temp[1], key);
		}
		int size = list.size();
		int index = 0;
		if (size > 8) {
			index = size - 8;
		}
		for (int i = index; i < size; i++) {
			System.out.println(list.get(i) + " " + map.get(list.get(i)));
		}
		System.out.println();
	}
}