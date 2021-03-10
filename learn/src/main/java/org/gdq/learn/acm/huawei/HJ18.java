package org.gdq.learn.acm.huawei;

import java.util.Scanner;

/**
 * @author gdq
 * date 2020/9/1
 * description ip地址
 */
public class HJ18 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int typeA = 0;
		int typeB = 0;
		int typeC = 0;
		int typeD = 0;
		int typeE = 0;
		int error = 0;
		int pri = 0;
		while (scanner.hasNextLine()) {
			String s = scanner.nextLine();
			String[] data = s.split("~");
			boolean errorFlag = false;
			try {
				String code = data[1];
				String[] tempCode = code.split("\\.");
				int ip1 = Integer.parseInt(tempCode[0]);
				StringBuilder biIp1 = new StringBuilder(Integer.toBinaryString(ip1));
				if (biIp1.length() < 8) {
					int l = 8 - biIp1.length();
					for (int i = 0; i < l; i++)
						biIp1.insert(0, "0");
				}
				int ip2 = Integer.parseInt(tempCode[1]);
				StringBuilder biIp2 = new StringBuilder(Integer.toBinaryString(ip2));
				if (biIp2.length() < 8) {
					int l = 8 - biIp2.length();
					for (int i = 0; i < l; i++)
						biIp2.insert(0, "0");
				}
				int ip3 = Integer.parseInt(tempCode[2]);
				StringBuilder biIp3 = new StringBuilder(Integer.toBinaryString(ip3));
				if (biIp3.length() < 8) {
					int l = 8 - biIp3.length();
					for (int i = 0; i < l; i++)
						biIp3.insert(0, "0");
				}
				int ip4 = Integer.parseInt(tempCode[3]);
				StringBuilder biIp4 = new StringBuilder(Integer.toBinaryString(ip4));
				if (biIp4.length() < 8) {
					int l = 8 - biIp4.length();
					for (int i = 0; i < l; i++)
						biIp4.insert(0, "0");
				}
				String biCode = biIp1 + biIp2.toString() + biIp3 + biIp4;
				if (ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 || ip3 < 0 || ip3 > 255 || ip4 < 0 || ip4 > 255) {
					errorFlag = true;
				} else {
					boolean flag = false;
					for (int i = 0; i < biCode.length(); i++) {
						if (biCode.charAt(i) == '0') {
							flag = true;
						}
						if (flag && biCode.charAt(i) == '1') {
							errorFlag = true;
							break;
						}
					}
					if (!flag || !biCode.contains("1")) {
						errorFlag = true;
					}
				}
			} catch (Exception ignored) {
				errorFlag = true;
			}
			if (errorFlag) {
				error++;
			} else {
				try {
					String ips = data[0];
					String[] tempIp = ips.split("\\.");
					int ip1 = Integer.parseInt(tempIp[0]);
					int ip2 = Integer.parseInt(tempIp[1]);
					int ip3 = Integer.parseInt(tempIp[2]);
					int ip4 = Integer.parseInt(tempIp[3]);
					if (ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 || ip3 < 0 || ip3 > 255 || ip4 < 0 || ip4 > 255) {
						error++;
						break;
					} else if (ip1 >= 1 && ip1 <= 126) {
						typeA++;
					} else if (ip1 >= 128 && ip1 <= 191) {
						typeB++;
					} else if (ip1 >= 192 && ip1 <= 223) {
						typeC++;
					} else if (ip1 >= 224 && ip1 <= 239) {
						typeD++;
					} else if (ip1 >= 240) {
						typeE++;
					}
					if (ip1 == 10 || (ip1 == 172 && ip2 >= 16 && ip2 <= 31) || (ip1 == 192 && ip2 == 168)) {
						pri++;
					}
				} catch (Exception ignored) {
					error++;
				}
			}
		}
		System.out.println(typeA + " " + typeB + " " + typeC + " " + typeD + " " + typeE + " " + error + " " + pri);
	}
}