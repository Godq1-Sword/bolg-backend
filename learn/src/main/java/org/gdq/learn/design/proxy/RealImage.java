package org.gdq.learn.design.proxy;

/**
 * Image实现对象
 *
 * @author gdq
 * @since 2021/8/18
 */
public class RealImage implements Image {

    // 文件名称
    public String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        System.out.println("RealImage print...");
    }
}
