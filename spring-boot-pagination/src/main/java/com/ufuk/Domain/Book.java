package com.ufuk.Domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Book {
    @Id
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private Date localDate;
}
