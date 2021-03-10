package org.gdq.bolg.core.constant;

/**
 * @author gdq
 * date 2020/12/8
 * description 静态常量类
 */
public class Attribute {

    public enum logType {
        debug("debug"),
        info("info"),
        error("error"),
        warning("warning");

        logType(String logType) {}
    }
}
