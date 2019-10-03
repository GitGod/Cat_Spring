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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/wlasciciele")
@RequiredArgsConstructor
public class WlascicielController {
    private final WlascicielService wlascicielService;
    private final CatService catService;


    @GetMapping
    String getAllWlasiciel(Model model) {
        model.addAttribute("wlasciciele", wlascicielService.findAllWlasciciele());
        return "wlasciciele";
    }


    @GetMapping("/pokazkoty/{id}")
    String pokazkoty(@PathVariable("id") Long id, Model model) {
        model.addAttribute("cats", wlascicielService.getById(id).getCats());
        return "catlist";
    }
    //@PostMapping("pokazkoty")
  //  RedirectView listCat(Cat cat, @RequestParam long wlascicielId) {

   //   Wlasciciel wlasciciel = wlascicielService.getById(wlascicielId);
   //   wlasciciel.getCats();
   //   RedirectView redirectView = new RedirectView();
   //     redirectView.setUrl("/listcat");
    //    return redirectView;
  //  }


    @GetMapping("/add")
    String AddWlasciciel(Model model) {
        return "addwlasciciel";
    }

    @PostMapping
    RedirectView saveWlasciciel(Wlasciciel wlasciciel) {
        wlascicielService.createWlasciciel(wlasciciel);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/wlasciciele");
        return redirectView;
    }

    @PostMapping("/delete/{id}")
    RedirectView deleteWlasciciel(@PathVariable("id") Long id) {
        wlascicielService.delete(id);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/wlasciciele");
        return redirectView;
    }

    @GetMapping("/edit/{id}")
    String editWlasciciel(@PathVariable("id") Long id, Model model) {
        model.addAttribute("wlasciciel", wlascicielService.getById(id));
        return "editwlasciciel";
    }

    @PostMapping("/edit")
    RedirectView editWlascicel(Wlasciciel wlasciciel) {
        wlascicielService.edit(wlasciciel);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/wlasciciele");
        return redirectView;
    }


}
