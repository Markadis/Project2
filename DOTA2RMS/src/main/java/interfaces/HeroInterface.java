package interfaces;

import org.hibernate.Session;

import data.Hero;

public interface HeroInterface {
	long createHero(Session session, String name, long id, String localizedName);
	Hero getHeroById(Session session, long id);
	Hero getHeroByName(Session session, String name);
}
