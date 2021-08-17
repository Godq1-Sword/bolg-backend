package org.gdq.learn.design.composite;

/**
 * 组合模式[Main]
 *
 * @author gdq
 * @since 2021/8/17
 */
public class Main {
    public static void main(String[] args) {
        Node node = new Node();
        Node parent = new Node();
        node.setParent(parent);
        System.out.println(node);
    }
}
