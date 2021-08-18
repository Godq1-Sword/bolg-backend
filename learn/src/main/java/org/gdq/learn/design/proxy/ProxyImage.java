package org.gdq.learn.design.proxy;

/**
 * Image代理对象
 *
 * @author gdq
 * @since 2021/8/18
 */
public class ProxyImage implements Image {

    // 文件名称
    private String fileName;

    // 代理真实对象
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        System.out.println("loading " + fileName);
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
