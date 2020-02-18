package com.ufuk.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker // enable edecek websocketin broker implementasyonunu
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
      registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS(); // sunucu dinliyor sunucuya mesaj burdan yazılacak
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) { // client dinliyor dışardaki clientler
        registry.enableSimpleBroker("/topic");
    }
}
