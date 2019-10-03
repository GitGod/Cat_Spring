package com.sda.catmvc.model;

import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "wlasciciele")
@Builder
@NoArgsConstructor
public class Wlasciciel {


    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @OneToMany(mappedBy = "wlasciciel", cascade = CascadeType.ALL)
   // @JoinColumn(name = "wlasciciel_id")
    private Set<Cat> cats;

    public Wlasciciel(String name,String surname ,Cat... cats) {
        this.name = name;
        this.surname=surname;
        this.cats = Stream.of(cats).collect(Collectors.toSet());
        this.cats.forEach(x -> x.setWlasciciel(this));
    }
    public Wlasciciel(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
