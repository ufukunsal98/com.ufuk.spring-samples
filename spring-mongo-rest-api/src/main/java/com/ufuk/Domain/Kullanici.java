package com.ufuk.Domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
@Data
public class Kullanici {
    @Id
    private String id;
    private String ad;
    private String soyadi;
    private HashMap özellikleri;
}
