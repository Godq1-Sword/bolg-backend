package org.gdq.learn.design.proxy;

/**
 * 代理模式[Main]
 *
 * @author gdq
 * @since 2021/8/18
 */
public class Main {
    public static void main(String[] args) {
        ProxyImage proxyImage = new ProxyImage("fileName");
        proxyImage.display();
        proxyImage.display();
    }
}
