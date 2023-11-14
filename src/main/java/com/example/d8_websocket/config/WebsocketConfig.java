package com.example.d8_websocket.config;

import com.example.d8_websocket.dto.WSMsg;
import com.example.d8_websocket.handler.CustomWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Sinks;

import java.util.Map;

@Configuration
public class WebsocketConfig {

    @Bean
    public SimpleUrlHandlerMapping handlerMapping(CustomWebSocketHandler handler){
        return new SimpleUrlHandlerMapping(Map.of("/message", handler), 1);
    }

    @Bean
    public WebSocketHandlerAdapter webSocketHandlerAdapter(){
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public Sinks.Many<String> sink(){
        return Sinks.many().multicast().directBestEffort();
    }

    @Bean
    public Sinks.Many<WSMsg> sink2(){
        return Sinks.many().multicast().directBestEffort();
    }

}
