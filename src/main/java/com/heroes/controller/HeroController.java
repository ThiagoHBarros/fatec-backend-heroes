package com.heroes.controller;


import java.util.List;
import java.util.Optional;
import com.heroes.entities.Hero;
import com.heroes.repository.HeroRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    
    @Autowired
    private HeroRepository repo;

    //EndPoint
    //Devolve todos os heroes
    //http://localhost:8080/heroes
    @GetMapping
    public List<Hero> getHeroes()
    {
        List<Hero> lista = repo.findAll();

        return lista;
    }


    //EndPoint
    //Devolve um Hero por Id
    //http://localhost:8080/heroes/{id}
    @GetMapping("{id}")
    public Hero getHero(@PathVariable Long id)
    {
        Optional<Hero> op = repo.findById(id);
        Hero hero = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return hero;
    }

}
