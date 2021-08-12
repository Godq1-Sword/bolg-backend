package org.gdq.learn.design.singleton;

/**
 * 单例模式 - 枚举[无构造方法,防止反序列化]
 *
 * @author gdq
 * date 2021/3/15
 */
public enum Example04 {
    // 单例变量
    INSTANCE;

    /**
     * 获取实例
     *
     * @return Example04 实例对象
     * @author gdq
     * @since 2021/3/15
     */
    public static Example04 getInstance() {
        return INSTANCE;
    }
}
