package com.ufuk.Controller;

import com.ufuk.Domain.KisiDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static  final String webUrl = "http://localhost:8080/kisi";
    @Autowired
    private RestTemplate restTemplate; // rest template authentication desteklediği için kullanımı güzeldir.

    @GetMapping()
    public ResponseEntity<List<KisiDto>> getKisiList() {
        ResponseEntity<List> result =  restTemplate.getForEntity(webUrl , List.class);
        List<KisiDto> kisiDtos = result.getBody();
        return ResponseEntity.ok(kisiDtos); // or //  return ResponseEntity.ok(result.getBody());
    }

    @PostMapping()
    public ResponseEntity<KisiDto> postKisi(@RequestBody KisiDto kisiDto) {
        return ResponseEntity.ok(restTemplate.postForEntity(webUrl , kisiDto , KisiDto.class).getBody());
    }

}
