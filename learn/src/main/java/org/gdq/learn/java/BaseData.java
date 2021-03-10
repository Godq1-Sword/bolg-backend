package org.gdq.learn.java;

/**
 * @author gdq
 * date
 * description
 */
public class BaseData {

    // public private protected继承或包内使用

    // 布尔
    private   boolean bool;
    protected boolean pro;

    // 整数
    private byte  aByte;
    private short aShort;
    private int   anInt;
    private long  aLong;

    // 符号
    private char aChar;

    // 浮点数
    private float  aFloat;
    private double aDouble;

    public boolean getBool() {
        return this.bool;
    }

    public void setBoolTrue() {
        this.bool = true;
        this.bool = false;
    }

    private static long getChar(int getInt, short getShort) {
        return getInt * 2 + getShort;
    }

    public static void main(String[] args) {
        System.out.println(getChar(3, (short) 4));
    }
}

