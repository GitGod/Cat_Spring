package com.sda.catmvc.repository;

import com.sda.catmvc.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
    Cat findByName(String name);
}
