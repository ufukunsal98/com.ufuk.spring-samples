package com.ufuk.Domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Notification implements Serializable {

    private String notificationId;
    private Date notificationCreatedAt;
    private Boolean seen;
    private String message;
}
