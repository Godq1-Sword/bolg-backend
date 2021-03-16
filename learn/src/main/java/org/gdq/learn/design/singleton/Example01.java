package org.gdq.learn.design.singleton;

/**
 * 单例模式
 *
 * @author gdq
 * date 2021/3/15
 */
public class Example01 {
    // 单例模式 - 核心私有构造方法[禁止额外初始化]
    private Example01() {}

    public final int hashCode = this.hashCode();

    // 饿汉式
    private static final Example01 instance = new Example01();

    public static Example01 getInstance() {
        return instance;
    }

    public int getHashCode() {
        return hashCode;
    }
}
