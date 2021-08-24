package org.gdq.learn.design.command;

/**
 * 卖出库存
 *
 * @author gdq
 * @since 2021/8/24
 */
public class SellStock implements Order {

    // 库存
    private final Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
