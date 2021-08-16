package org.gdq.learn.design.bridge;

import lombok.Getter;
import lombok.Setter;

/**
 * 桥接器
 *
 * @author gdq
 * @since 2021/8/16
 */
@Getter
@Setter
public abstract class BridgeAbsClass {

    private BridgeApi bridgeApi;

    /**
     * 打印
     *
     * @author gdq
     * @since 2021/8/16
     */
    public abstract void print();

}
