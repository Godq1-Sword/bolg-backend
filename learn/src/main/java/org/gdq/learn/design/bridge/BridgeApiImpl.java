package org.gdq.learn.design.bridge;

/**
 * 桥接接口实现类
 *
 * @author gdq
 * @since 2021/8/16
 */
public class BridgeApiImpl implements BridgeApi {

    @Override
    public void print() {
        System.out.println("BridgeApi print...");
    }
}
