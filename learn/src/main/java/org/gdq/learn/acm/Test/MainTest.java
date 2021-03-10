package org.gdq.learn.acm.Test;

import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author gdq
 * date
 * description
 */
public class MainTest {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<Integer> count = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			count.add(1);
			count.add(2);
			count.add(3);
		}
		CountDownLatch countDownLatch = new CountDownLatch(5);
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		CountNum countNum = new CountNum();
		for (int i = 0; i < 5; i++) {
			int start = i * 600000;
			int end = start + 600000;
			executorService.execute(() -> {
				for (int j = start; j < end; j++) {
					countNum.setCount(count.get(j));
				}
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("时间:" + (endTime - startTime));
		System.out.println(countNum);
	}
}
