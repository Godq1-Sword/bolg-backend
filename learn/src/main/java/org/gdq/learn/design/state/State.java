package org.gdq.learn.design.state;

/**
 * 状态接口
 *
 * @author gdq
 * @since 2021/9/2
 */
public interface State {
    /**
     * 行为变更
     *
     * @param context 上下文
     * @author gdq
     * @since 2021/9/2
     */
    void doAction(Context context);
}
