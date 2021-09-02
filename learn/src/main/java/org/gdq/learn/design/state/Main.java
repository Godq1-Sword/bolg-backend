package org.gdq.learn.design.state;

/**
 * 状态模式[Main]
 *
 * @author gdq
 * @since 2021/9/2
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);
        System.out.println(context.getState().toString());
        StopState stopState = new StopState();
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
