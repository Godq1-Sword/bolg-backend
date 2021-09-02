package org.gdq.learn.design.template;

/**
 * @author gdq
 * @since 2021/9/2
 */
public abstract class Game {
    /**
     * 初始化
     *
     * @author gdq
     * @since 2021/9/2
     */
    abstract void initialize();

    /**
     * 开始游戏
     *
     * @author gdq
     * @since 2021/9/2
     */
    abstract void startPlay();

    /**
     * 结束游戏
     *
     * @author gdq
     * @since 2021/9/2
     */
    abstract void endPlay();

    /**
     * play
     *
     * @author gdq
     * @since 2021/9/2
     */
    public final void play() {
        //初始化游戏
        initialize();
        //开始游戏
        startPlay();
        //结束游戏
        endPlay();
    }
}
