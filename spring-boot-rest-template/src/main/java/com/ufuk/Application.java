package com.ufuk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class , args);
    }

    @Bean // spring boot uygulaması yüklendikten sonra ıoc container içerisine koyacak ve biz autowired veya constructor ijection ile çağırabilcez
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
