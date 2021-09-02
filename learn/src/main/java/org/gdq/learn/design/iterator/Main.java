package org.gdq.learn.design.iterator;

/**
 * 迭代器模式[Main]
 *
 * @author gdq
 * @since 2021/8/30
 */
public class Main {
    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            System.out.println("Name : " + iter.next());
        }
    }
}
