package com.ufuk.Controller;

import com.ufuk.Domain.Kullanici;
import com.ufuk.Repository.KullaniciRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/kullanici")
@RequiredArgsConstructor
public class KullaniciController {

    @Autowired
    private final KullaniciRepository kullaniciRepository;

    @PostConstruct
    public void init() {
        Kullanici kullanici = new Kullanici();
        kullanici.setAd("ufuk remzi");
        kullanici.setSoyadi("ünsal");
        kullaniciRepository.save(kullanici);
    }

    public ResponseEntity<Kullanici> ekle(@RequestBody Kullanici kullanici) {
        return ResponseEntity.ok(kullaniciRepository.save(kullanici));
    }
    @GetMapping()
    public ResponseEntity<List<Kullanici>> tumunuListele() {
        return ResponseEntity.ok(kullaniciRepository.findAll());
    }
}
