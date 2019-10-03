package com.sda.catmvc.Service;

import com.sda.catmvc.model.Cat;
import com.sda.catmvc.model.Wlasciciel;
import com.sda.catmvc.repository.CatRepository;
import com.sda.catmvc.repository.WlascicielRepository;
import lombok.Builder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Builder
@Service
public class WlascicielService implements InitializingBean {

    private final WlascicielRepository wlascicielRepository;

    public WlascicielService(WlascicielRepository wlascicielRepository) {
        this.wlascicielRepository = wlascicielRepository;
    }

    public void createWlasciciel(Wlasciciel wlasciciel) {
        wlascicielRepository.save(wlasciciel);
    }

    public List<Wlasciciel> findAllWlasciciele() {
        return wlascicielRepository.findAll();
    }

    public void delete(Long id) {
        wlascicielRepository.deleteById(id);
    }

    public void edit(Wlasciciel wlasiciel) {
        wlascicielRepository.save(wlasiciel);
    }

    public Wlasciciel getById(Long id) {
        // Cat excat = catRepository.getOne(id);
        //  if(excat != null){
        //      return excat;
        // }else{
        //      throw new RuntimeException();
        //  }

        return wlascicielRepository.findById(id).orElseThrow(RuntimeException::new);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        HashSet<Cat> x = new HashSet<Cat>();
        Cat cat = Cat.builder().name("lel").age(11).hasTail(true).lives(9).build();
        Cat cat2 = Cat.builder().name("lel").age(11).hasTail(true).lives(9).build();
        x.add(cat);
        x.add(cat2);

        Wlasciciel wlasciciel = Wlasciciel.builder().name("Michal").surname("Kopytko").build();
        Wlasciciel wlasciciel2 = Wlasciciel.builder().name("Anna").surname("Drewno").build();

        createWlasciciel(wlasciciel);
        createWlasciciel(wlasciciel2);

    }


}
