package org.gdq.learn.design.build;

import lombok.ToString;

/**
 * 建造者模式例子
 *
 * @author gdq
 * @since 2021/8/12
 */
@ToString
public class Example {
    // 组件1
    private String item1;
    // 组件2
    private int item2;
    // 组件3
    private double item3;
    // 组件4
    private boolean item4;

    public static ExampleBuilder builder() {
        return new ExampleBuilder();
    }

    // 建造者
    public static class ExampleBuilder {
        // 组件1
        private String item1;
        // 组件2
        private int item2;
        // 组件3
        private double item3;
        // 组件4
        private boolean item4;

        /**
         * 构造组件1
         *
         * @param item1 组件1
         * @return ExampleBuilder 返回建造者
         * @author gdq
         * @since 2021/8/12
         */
        public ExampleBuilder item1(String item1) {
            this.item1 = item1;
            return this;
        }

        /**
         * 构造组件2
         *
         * @param item2 组件2
         * @return ExampleBuilder 返回建造者
         * @author gdq
         * @since 2021/8/12
         */
        public ExampleBuilder item2(int item2) {
            this.item2 = item2;
            return this;
        }

        /**
         * 构造组件3
         *
         * @param item3 组件3
         * @return ExampleBuilder 返回建造者
         * @author gdq
         * @since 2021/8/12
         */
        public ExampleBuilder item3(double item3) {
            this.item3 = item3;
            return this;
        }

        /**
         * 构造组件4
         *
         * @param item4 组件4
         * @return ExampleBuilder 返回建造者
         * @author gdq
         * @since 2021/8/12
         */
        public ExampleBuilder item4(boolean item4) {
            this.item4 = item4;
            return this;
        }

        public Example build() {
            Example example = new Example();
            example.item1 = this.item1;
            example.item2 = this.item2;
            example.item3 = this.item3;
            example.item4 = this.item4;
            return example;
        }
    }
}
