package org.gdq.learn.design.state;

/**
 * StartState
 *
 * @author gdq
 * @since 2021/9/2
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString() {
        return "Start State";
    }
}
