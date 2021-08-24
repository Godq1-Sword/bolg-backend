package org.gdq.learn.design.responsibility;

import lombok.Setter;

/**
 * 抽象日志类
 *
 * @author gdq
 * @since 2021/8/24
 */
@Setter
public abstract class AbstractLogger {


    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    /**
     * 链式记录日志
     *
     * @param message 消息
     * @author gdq
     * @since 2021/8/24
     */
    public void logMessage(String message) {
        write(message);
        if (nextLogger != null) {
            nextLogger.logMessage(message);
        }
    }

    /**
     * 记录日志
     *
     * @param message 消息
     * @author gdq
     * @since 2021/8/24
     */
    abstract protected void write(String message);
}
