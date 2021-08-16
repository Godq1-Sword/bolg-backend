package org.gdq.learn.design.adapter;

/**
 * 适配器
 *
 * @author gdq
 * @since 2021/8/16
 */
public class AdapterExample extends Example implements AdapterFunction {

    @Override
    public long getId() {
        return super.id;
    }
}
