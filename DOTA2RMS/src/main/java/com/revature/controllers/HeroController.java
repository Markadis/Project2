package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.revature.data.Hero;
import com.revature.services.HeroService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/hero")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hero> getAllHeroes() {
		return heroService.findAllHeroes();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hero getHeroById(@PathVariable("id") long id) {
		return heroService.findHeroById(id);
	}
	
	@GetMapping(value="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hero findHeroByName(@PathVariable("name") String name) {
		return heroService.findHeroByName(name);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Hero createHero(@RequestBody Hero hero) {
		return heroService.createHero(hero);
	}

}
