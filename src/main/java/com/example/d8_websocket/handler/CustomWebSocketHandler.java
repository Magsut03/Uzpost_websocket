package com.example.d8_websocket.handler;

import com.example.d8_websocket.dto.WSMsg;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

import java.awt.image.DataBufferByte;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.function.Function;

@Component
public class CustomWebSocketHandler implements WebSocketHandler {

    private final Sinks.Many<WSMsg> sink;

    public CustomWebSocketHandler(Sinks.Many<WSMsg> sink) {
        this.sink = sink;
    }


    @Override
    public Mono<Void> handle(WebSocketSession session) {
        Flux<WebSocketMessage> f =
                sink.asFlux()
                        .map(s -> session
                                .binaryMessage(dataBufferFactory ->
                                        dataBufferFactory.wrap(s.toString().getBytes())));

        return session.send(f);
    }


}
