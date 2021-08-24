package org.gdq.learn.design.command;

/**
 * 买入库存
 *
 * @author gdq
 * @since 2021/8/24
 */
public class BuyStock implements Order {

    // 库存
    private final Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
