package org.gdq.learn.design.state;

/**
 * StopState
 *
 * @author gdq
 * @since 2021/9/2
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString() {
        return "Stop State";
    }
}