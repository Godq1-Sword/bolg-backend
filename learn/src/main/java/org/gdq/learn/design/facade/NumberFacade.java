package org.gdq.learn.design.facade;

/**
 * 外观门面
 *
 * @author gdq
 * @since 2021/8/18
 */
public class NumberFacade {

    /**
     * 数字相加
     *
     * @param a 数字a
     * @param b 数字b
     * @return double sum
     * @author gdq
     * @since 2021/8/18
     */
    public double add(double a, double b) throws Exception {
        if (a + b < Double.MAX_VALUE) {
            return a + b;
        } else {
            throw new Exception("数据越界");
        }
    }
}
