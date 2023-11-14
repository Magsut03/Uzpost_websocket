package com.example.d8_websocket.handler;

import com.example.d8_websocket.dto.WSMsg;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Component
public class CustomWebSocketHandler implements WebSocketHandler {

    private final Sinks.Many<WSMsg> sink;

    public CustomWebSocketHandler(Sinks.Many<WSMsg> sink) {
        this.sink = sink;
    }


    @Override
    public Mono<Void> handle(WebSocketSession session) {
        var f = sink.asFlux().map(s -> session.textMessage(s.toString()));

        return session.send(f);
    }


}
