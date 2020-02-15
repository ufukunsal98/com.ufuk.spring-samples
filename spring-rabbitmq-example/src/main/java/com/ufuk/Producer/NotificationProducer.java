package com.ufuk.Producer;

import com.ufuk.Domain.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${sr.rabbit.routing.name}")
    private String bindingKey;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void Init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setMessage("notification message");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification) {
        System.out.println("notification:send" + notification);
        rabbitTemplate.convertAndSend(exchangeName , bindingKey, notification);
    }
}
