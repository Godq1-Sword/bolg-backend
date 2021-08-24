package org.gdq.learn.design.responsibility;

/**
 * ErrorLogger
 *
 * @author gdq
 * @since 2021/8/24
 */
public class ErrorLogger extends AbstractLogger {

    @Override
    protected void write(String message) {
        System.out.println("ErrorLogger log:" + message);
    }
}
