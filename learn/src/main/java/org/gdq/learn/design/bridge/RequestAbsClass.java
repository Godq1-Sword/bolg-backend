package org.gdq.learn.design.bridge;

/**
 * 需求Api
 *
 * @author gdq
 * @since 2021/8/16
 */
public class RequestAbsClass extends BridgeAbsClass {

    @Override
    public void print() {
        System.out.println("RequestAbsClass print...");
        getBridgeApi().print();
    }
}
