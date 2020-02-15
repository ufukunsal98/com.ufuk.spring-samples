package com.ufuk.Controller;

import com.ufuk.Domain.Kisi;
import com.ufuk.Repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/kisi")
@RequiredArgsConstructor
public class KisiController {

    @Autowired
    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setAd("ufuk");
        kisi.setSoyadi("ünsal");
        kisi.setAdres("ankara polatlı test");
        kisi.setId("K-0098");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisiRepository.save(kisi);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        return ResponseEntity.ok(kisiRepository.getByAdLikeOrSoyadiLike(search , search));
    }

}
