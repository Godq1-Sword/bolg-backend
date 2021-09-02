package org.gdq.learn.design.iterator;

/**
 * 姓名库
 *
 * @author gdq
 * @since 2021/8/30
 */
public class NameRepository implements Container {

    // 姓名数组
    public String[] names = {"Robert", "John", "Julie", "Lora"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        // 下标
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            return this.hasNext() ? names[index++] : null;
        }
    }
}
