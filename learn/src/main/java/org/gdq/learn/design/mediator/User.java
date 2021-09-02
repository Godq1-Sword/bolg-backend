package org.gdq.learn.design.mediator;

import lombok.Data;

/**
 * 用户
 *
 * @author gdq
 * @since 2021/9/2
 */
@Data
public class User {
    // 姓名
    private String name;

    public User(String name) {
        this.name = name;
    }

    // 发送消息
    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
