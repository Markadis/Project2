package com.revature.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.data.Hero;
import com.revature.interfaces.HeroInterface;
import com.revature.repositories.HeroRepository;

@Service
@Transactional
public class HeroService implements HeroInterface{

	@Autowired
	private HeroRepository heroRepository;

	@Override
	public Hero createHero(Hero hero) {
		return heroRepository.save(hero);
	}

	@Override
	public Hero findHeroById(long id) {
		return heroRepository.getOne(id);
	}

	@Override
	public Hero findHeroByName(String name) {
		return heroRepository.findByLocalizedName(name);
	}

	@Override
	public List<Hero> findAllHeroes() {
		return heroRepository.findAll();
	}
	
}
