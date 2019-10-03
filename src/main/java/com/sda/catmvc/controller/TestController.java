package com.sda.catmvc.controller;


import com.sda.catmvc.model.Cat;
import com.sda.catmvc.repository.CatRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final CatRepository catRepository;

    public TestController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @GetMapping("/{name}")
    Cat getCytbyName(@PathVariable("name") String name){
        return catRepository.findByName(name);
    }
    @GetMapping("/{name}/{age}")
    Cat getCytbyName(@PathVariable("name") String name,@PathVariable("age") int age){
    return catRepository.findByName(name);
}
}
