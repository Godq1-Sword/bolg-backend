package org.gdq.learn.design.responsibility;

/**
 * 责任链模式[Main]
 *
 * @author gdq
 * @since 2021/8/24
 */
public class Main {
    public static void main(String[] args) {
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger errorLogger = new ErrorLogger();
        errorLogger.setNextLogger(infoLogger);
        errorLogger.logMessage("test");
    }
}
