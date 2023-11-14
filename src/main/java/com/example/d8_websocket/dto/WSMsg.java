package com.example.d8_websocket.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder
public class WSMsg implements Serializable {
    private String user;
    private String destination;
    private Serializable payload;
    private String sessionId;

    public WSMsg(String user, String destination, Serializable payload) {
        this.user = user;
        this.destination = destination;
        this.payload = payload;
    }

    public WSMsg(String user, String destination, Serializable payload, String sessionId) {
        this.user = user;
        this.destination = destination;
        this.payload = payload;
        this.sessionId = sessionId;
    }
}
