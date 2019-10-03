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
import java.util.List;
import java.util.Optional;
@Builder
@Service
public class CatService implements InitializingBean {

    private final CatRepository catRepository;

    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }



    public void createCat(Cat cat) {

        catRepository.save(cat);

    }

    public List<Cat> findAllCats() {
        return catRepository.findAll();
    }

    public void delete(Long id) {
        catRepository.deleteById(id);
    }

    public void edit(Cat cat) {
        catRepository.save(cat);
    }

    public Cat getById(Long id) {
        // Cat excat = catRepository.getOne(id);
        //  if(excat != null){
        //      return excat;
        // }else{
        //      throw new RuntimeException();
        //  }

        return catRepository.findById(id).orElseThrow(RuntimeException::new);

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Cat cat = Cat.builder().name("lel").age(11).hasTail(true).lives(9).build();
        Cat cat2 = Cat.builder().name("lel").age(11).hasTail(true).lives(9).build();

    }


}
