package org.gdq.learn.design.strategy;

/**
 * 策略模式[接口]
 *
 * @author gdq
 * date 2021/3/16
 */
public interface Strategy {
    /**
     * 计算并返回结果
     *
     * @param num1 数字1
     * @param num2 数字2
     * @return int 操作结果
     * @author gdq 2021/3/16
     */
    int doOperation(int num1, int num2);
}
