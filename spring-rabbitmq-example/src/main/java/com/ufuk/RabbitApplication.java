package com.ufuk;

import com.ufuk.Domain.Notification;
import com.ufuk.Producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class RabbitApplication {


    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class ,args);
    }
}

