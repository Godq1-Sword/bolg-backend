package org.gdq.learn.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 消费者
 *
 * @author gdq
 * @since 2021/8/24
 */
public class Broker {

    // 命令List
    private final List<Order> orderList = new ArrayList<>();

    /**
     * 添加命令
     *
     * @param order 命令
     * @author gdq
     * @since 2021/8/24
     */
    public void takeOrder(Order order) {
        orderList.add(order);
    }

    /**
     * 执行命令
     *
     * @author gdq
     * @since 2021/8/24
     */
    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
