package org.gdq.learn.design.strategy;

/**
 * 策略模式[操作加]
 *
 * @author gdq
 * date 2021/3/16
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
