package com.example.d8_websocket.controller;

import com.example.d8_websocket.dto.WSMsg;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

@RestController
@RequestMapping("/api")
public class DemoController {

    private final Sinks.Many<WSMsg> sink;


    public DemoController(Sinks.Many<WSMsg> sink) {
        this.sink = sink;
    }

    @PostMapping("/notification")
    public void receive(@RequestBody WSMsg data){
        sink.emitNext(data,Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
