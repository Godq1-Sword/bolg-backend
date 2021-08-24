package org.gdq.learn.design.command;

/**
 * 命令模式[Main]
 *
 * @author gdq
 * @since 2021/8/24
 */
public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Order buyStock = new BuyStock(stock);
        Order sellStock = new SellStock(stock);
        Broker broker = new Broker();
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        broker.placeOrders();
    }
}
