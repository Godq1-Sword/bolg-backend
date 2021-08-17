package org.gdq.learn.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器模式[Main]
 *
 * @author gdq
 * @since 2021/8/17
 */
public class Main {
    public static void main(String[] args) {
        List<Example> examples = new ArrayList<>();
        examples.add(new Example());
        examples.add(Example.builder().id(1L).build());
        IdFilter idFilter = new IdFilter();
        System.out.println(idFilter.filter(examples));
    }
}
