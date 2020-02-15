package com.ufuk.Config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;

@Configuration
public class RabbitMQConfiguration {
    @Value("${sr.rabbit.queue.name}")
    private String qName;
    @Value("${sr.rabbit.routing.name}")
    private String bindingKey;
    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Bean
    public  Queue queue() {
        return new Queue(qName);
    }

    @Bean
    public DirectExchange exchange(){
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding binding(final Queue queue , final DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(bindingKey);
    }


}
