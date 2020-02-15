package com.ufuk.Domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kisi_adres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Adres implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres" , allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres" , strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 500 , name = "adres")
    private String adres;
    @Column(name = "aktif")
    private Boolean aktif;
    @Enumerated
    private AdresTip adresTip;
    enum  AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DEGER
    }
}
