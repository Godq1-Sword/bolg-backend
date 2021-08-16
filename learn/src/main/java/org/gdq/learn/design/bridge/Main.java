package org.gdq.learn.design.bridge;

/**
 * 桥接模式[Main]
 *
 * @author gdq
 * @since 2021/8/16
 */
public class Main {
    public static void main(String[] args) {
        RequestAbsClass requestApi = new RequestAbsClass();
        requestApi.setBridgeApi(new BridgeApiImpl());
        requestApi.print();
    }
}
