package com.ufuk.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mesaj")
public class MesajController {

    @GetMapping
    public String mesajVer() {
        return "Docker image nin içinden mesaj ver..";
    }
}
