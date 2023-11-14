package com.example.d8_websocket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WSReturnOrderFromLockerPostDTO implements Serializable {
    private Long orderId;
    private String barcode;
    /*private String content;
    private String contentRu;
    private String contentEn;*/
    private ZonedDateTime dispatchedDate;
    private Long pushLogId;
    private String warehouseName;
}
