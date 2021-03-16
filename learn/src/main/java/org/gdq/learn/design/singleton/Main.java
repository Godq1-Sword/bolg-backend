package org.gdq.learn.design.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试用例
 *
 * @author gdq
 * date 2021/3/15
 */
public class Main {
    // hashCodeArray
    private static final int[] array = new int[4];

    // 初始化单例Hashcode
    static {
        array[0] = Example01.getInstance().getHashCode();
        array[1] = Example02.getInstance().getHashCode();
        array[2] = Example03.getInstance().getHashCode();
        array[3] = Example04.getInstance().hashCode();
    }

    // Main
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    throwException(Example01.getInstance().getHashCode(), 0);
                    throwException(Example02.getInstance().getHashCode(), 1);
                    throwException(Example03.getInstance().getHashCode(), 2);
                    throwException(Example04.getInstance().hashCode(), 3);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("Main Success");
    }

    /**
     * 对比hashCode抛异常
     *
     * @param hashCode 单例hashCode
     * @param index    arrayIndex
     * @throws Exception 主动抛出异常
     * @author gdq 2021/3/15
     */
    private static void throwException(int hashCode, int index) throws Exception {
        if (hashCode != array[index]) { throw new Exception("单例模式Example0" + index + "Error"); }
    }
}
