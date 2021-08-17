package org.gdq.learn.design.filter;

import java.util.List;

/**
 * 过滤器接口
 *
 * @author gdq
 * @since 2021/8/17
 */
public interface Filter {
    List<Example> filter(List<Example> examples);
}
