package com.revature.interfaces;

import org.hibernate.Session;

import com.revature.data.Hero;

public interface HeroInterface {
	long createHero(Session session, String name, long id, String localizedName);
	Hero getHeroById(Session session, long id);
	Hero getHeroByName(Session session, String name);
}
