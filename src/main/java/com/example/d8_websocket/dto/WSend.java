package com.example.d8_websocket.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * For WebSocket
 */
@Data
@NoArgsConstructor
public class WSend<T extends Serializable> implements Serializable {
    private String status;
    private T data;

    public WSend(T data) {
        this.data = data;
    }

    public WSend(T data, String status) {
        this.status = status;
        this.data = data;
    }
}
