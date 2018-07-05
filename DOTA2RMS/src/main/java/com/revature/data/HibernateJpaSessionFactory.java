package com.revature.data;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class HibernateJpaSessionFactory {
	
	private SessionFactory hibernateFactory;
	
	@Autowired
	public HibernateJpaSessionFactory(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.hibernateFactory = factory.unwrap(SessionFactory.class);
	  }

	public SessionFactory getHibernateFactory() {
		return hibernateFactory;
	}

	public void setHibernateFactory(SessionFactory hibernateFactory) {
		this.hibernateFactory = hibernateFactory;
	}
	
	
	
}
