package com.sda.catmvc.repository;

import com.sda.catmvc.model.Wlasciciel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WlascicielRepository  extends JpaRepository<Wlasciciel, Long> {
    Wlasciciel findByName(String name);
}
