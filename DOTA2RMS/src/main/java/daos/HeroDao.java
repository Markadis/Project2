package daos;

import org.hibernate.Session;
import org.hibernate.Transaction;

import data.Hero;
import interfaces.HeroInterface;

public class HeroDao implements HeroInterface{

	@Override
	public long createHero(Session session, String name, long id, String localizedName) {
		Transaction transaction = session.beginTransaction();
		Hero hero = new Hero(name, id, localizedName);
		session.merge(hero);
		transaction.commit();
		return hero.getId();
	}

	@Override
	public Hero getHeroById(Session session, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hero getHeroByName(Session session, String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
