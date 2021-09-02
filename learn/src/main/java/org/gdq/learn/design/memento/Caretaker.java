package org.gdq.learn.design.memento;

import lombok.Data;

/**
 * 备忘录管理员角色
 *
 * @author gdq
 * @since 2021/9/2
 */
@Data
public class Caretaker {
    // 备忘录角色
    private Memento memento;
}
