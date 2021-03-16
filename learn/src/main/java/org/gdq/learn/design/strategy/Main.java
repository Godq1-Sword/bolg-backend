package org.gdq.learn.design.strategy;

/**
 * 策略模式[Main]
 *
 * @author gdq
 * date 2021/3/16
 */
public class Main {

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        int numAdd = new OperationAdd().doOperation(num1, num2);
        int numMultiply = new OperationMultiply().doOperation(num1, num2);
        System.out.println("策略模式[操作加]结果:" + numAdd + "\n策略模式[操作减]结果:" + numMultiply);
    }
}
