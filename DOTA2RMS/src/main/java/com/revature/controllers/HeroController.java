package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import com.revature.data.Hero;
import com.revature.services.HeroService;

@RestController
@RequestMapping("/heroes")
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

	@PostMapping(value="/create", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hero createHero(@RequestParam("name") String name, @RequestParam("id") long id, @RequestParam("localizedname") String localizedname) {
		Hero hero = new Hero(name, id, localizedname);
		return heroService.createHero(hero);
	}

	@PutMapping(value="/update", produces=MediaType.APPLICATION_JSON_VALUE)
	public Hero updateHero(@RequestParam("name") String name, @RequestParam("id") long id, @RequestParam("localizedname") String localizedname) {
		Hero hero = new Hero(name, id, localizedname);
		return heroService.updateHero(hero);
	}
}
