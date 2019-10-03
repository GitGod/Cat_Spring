package com.sda.catmvc.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity(name = "cats")
@Builder
@NoArgsConstructor
public class Cat {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
    private boolean hasTail;
    private int lives;

    @ManyToOne
    @JoinColumn
    private Wlasciciel wlasciciel;

    public Cat(String name, int age, boolean hasTail, int lives, Wlasciciel wlasciciel) {
        this.name = name;
        this.age = age;
        this.hasTail = hasTail;
        this.lives = lives;
        this.wlasciciel = wlasciciel;
    }

    public Cat(String name, int age, boolean hasTail, int lives) {
        this.name = name;
        this.age = age;
        this.hasTail = hasTail;
        this.lives = lives;
    }
}
