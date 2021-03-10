package org.gdq.learn.acm.Test;

import lombok.Data;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gdq
 * date
 * description
 */
@Data
@ToString
public class CountNum {
	private AtomicInteger count1 = new AtomicInteger(0);
	private AtomicInteger count2 = new AtomicInteger(0);
	private AtomicInteger count3 = new AtomicInteger(0);

	public void setCount(int i) {
		if (i == 1) {
			count1.incrementAndGet();
		} else if (i == 2) {
			count2.incrementAndGet();
		} else {
			count3.incrementAndGet();
		}
	}

//	private int count1 = 0;
//	private int count2 = 0;
//	private int count3 = 0;
//
//	public void setCount(int i) {
//		if (i == 1) {
//			count1++;
//		} else if (i == 2) {
//			count2++;
//		} else {
//			count3++;
//		}
//	}
}
