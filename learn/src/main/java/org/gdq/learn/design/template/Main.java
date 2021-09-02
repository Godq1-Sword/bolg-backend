package org.gdq.learn.design.template;

/**
 * 模板模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
