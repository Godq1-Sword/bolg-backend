package org.gdq.learn.design.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * id过滤器
 *
 * @author gdq
 * @since 2021/8/17
 */
public class IdFilter implements Filter {
    @Override
    public List<Example> filter(List<Example> examples) {
        return examples.stream().filter(example -> example.getId() != null).collect(Collectors.toList());
    }
}
