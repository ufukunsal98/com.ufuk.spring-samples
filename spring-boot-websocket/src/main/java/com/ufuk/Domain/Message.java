package com.ufuk.Domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Message {
    private String sender;
    private String message;
}
