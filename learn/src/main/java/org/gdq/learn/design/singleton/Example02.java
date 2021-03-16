package org.gdq.learn.design.singleton;

/**
 * 单例模式 - 懒汉式
 *
 * @author gdq
 * date 2021/3/15
 */
public class Example02 {
    // 单例模式 - 核心私有构造方法[禁止额外初始化]
    private Example02() {}

    public final int hashCode = this.hashCode();

    // 懒汉式 - doubleCheck / volatile屏蔽指令重排序
    private static volatile Example02 INSTANCE = null;

    public static Example02 getInstance() {
        if (INSTANCE == null) {
            synchronized (Example02.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Example02();
                }
            }
        }
        return INSTANCE;
    }

    public int getHashCode() {
        return hashCode;
    }
}
