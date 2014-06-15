package br.org.frameworkdemoiselle.cursoJPA.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory entityManagerFactory
	= Persistence.createEntityManagerFactory("cursoJPA-ds");
	
	public static EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}
}
