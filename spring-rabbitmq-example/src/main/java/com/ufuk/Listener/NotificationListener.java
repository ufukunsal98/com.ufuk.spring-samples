package com.ufuk.Listener;

import com.ufuk.Domain.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "ufuk")
    public void onMessage(Notification notification) {
        System.out.println(notification.toString());
    }
}
