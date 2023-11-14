package com.example.d8_websocket.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Sinks;

@RestController
public class DemoController {

    private final Sinks.Many<String> sink;


    public DemoController(Sinks.Many<String> sink) {
        this.sink = sink;
    }

    @PostMapping
    public void receive(@RequestBody String data){
        sink.emitNext(data,Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
