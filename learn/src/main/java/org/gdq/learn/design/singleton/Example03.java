package org.gdq.learn.design.singleton;

/**
 * 单例模式 - 懒汉式[静态内部类]
 *
 * @author gdq
 * date 2021/3/15
 */
public class Example03 {
    // 单例模式 - 核心私有构造方法[禁止额外初始化]
    private Example03() {}

    public final int hashCode = this.hashCode();

    // 静态内部类 - jvm控制类只有一次初始化
    private static class Example03Holder {
        private static final Example03 INSTANCE = new Example03();
    }

    /**
     * 获取实例
     *
     * @return Example03 实例对象
     * @author gdq
     * @since 2021/3/15
     */
    public static Example03 getInstance() {
        return Example03Holder.INSTANCE;
    }

    public int getHashCode() {
        return hashCode;
    }
}
