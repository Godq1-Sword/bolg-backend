package org.gdq.learn.design.mediator;

import java.util.Date;

/**
 * 聊天室
 *
 * @author gdq
 * @since 2021/9/2
 */
public class ChatRoom {
    /**
     * 展示消息
     *
     * @param user    用户
     * @param message 消息
     * @author gdq
     * @since 2021/9/2
     */
    public static void showMessage(User user, String message) {
        System.out.println(new Date() + " [" + user.getName() + "] : " + message);
    }
}
