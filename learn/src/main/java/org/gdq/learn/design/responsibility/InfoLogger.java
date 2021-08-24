package org.gdq.learn.design.responsibility;

/**
 * InfoLogger
 *
 * @author gdq
 * @since 2021/8/24
 */
public class InfoLogger extends AbstractLogger {

    @Override
    protected void write(String message) {
        System.out.println("InfoLogger log:" + message);
    }
}
