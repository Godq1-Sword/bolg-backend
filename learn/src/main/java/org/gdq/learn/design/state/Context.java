package org.gdq.learn.design.state;

import lombok.Data;

/**
 * 上下文
 *
 * @author gdq
 * @since 2021/9/2
 */
@Data
public class Context {
    // 状态
    private State state;

    public Context() {
        state = null;
    }
}
