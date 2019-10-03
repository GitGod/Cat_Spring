package com.sda.catmvc.controller;

import com.sda.catmvc.Service.CatService;
import com.sda.catmvc.Service.WlascicielService;
import com.sda.catmvc.model.Cat;
import com.sda.catmvc.model.Wlasciciel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/cats")
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;
    private final WlascicielService wlascicielService;


    @GetMapping
    String getAllCats(Model model) {
        model.addAttribute("cats", catService.findAllCats());
        return "cats";
    }
    @GetMapping("/add")
    String AddCat(Model model) {
        model.addAttribute("wlasciciele",wlascicielService.findAllWlasciciele());

        return "addcat";
    }
    @PostMapping
    RedirectView saveCat(Cat cat, @RequestParam long wlascicielId){

        Wlasciciel wlasciciel = wlascicielService.getById(wlascicielId);
        cat.setWlasciciel(wlasciciel);
        catService.createCat(cat);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cats");
        return redirectView;
    }
    @PostMapping("/delete/{id}")
    RedirectView deleteCat(@PathVariable("id") Long id){
        catService.delete(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cats");
        return redirectView;
    }
    @GetMapping("/edit/{id}")
    String editCat(@PathVariable("id") Long id, Model model) {
        model.addAttribute("wlasciciele",wlascicielService.findAllWlasciciele());
        model.addAttribute("cat",catService.getById(id));
        return "editcat";
    }
    @PostMapping("/edit")
    RedirectView editCat(Cat cat,@RequestParam long wlascicielId){
        Wlasciciel wlasciciel = wlascicielService.getById(wlascicielId);
        cat.setWlasciciel(wlasciciel);
        catService.edit(cat);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/cats");
        return redirectView;
    }


}
