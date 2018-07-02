package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.revature.data.Hero;
import com.revature.services.HeroService;

@RestController
@RequestMapping("/hero")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Hero> getAllHeroes() {
		return heroService.findAllHeroes();
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Hero getHeroById(@PathVariable("id") Integer id) {
		return heroService.findHeroById(id);
	}

	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Hero createHero(@RequestBody Hero hero) {
		return heroService.createHero(hero);
	}

}
