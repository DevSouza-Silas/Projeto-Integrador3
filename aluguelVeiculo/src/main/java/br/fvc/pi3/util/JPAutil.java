package br.fvc.pi3.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAutil {
	
	public static EntityManagerFactory emf = null;
	
	static {
		init();
	}
	
	
	private static void init() {
		try {
			
			if (emf == null) {
				emf = Persistence.createEntityManagerFactory("aluguelVeiculo");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static EntityManager getEntityManager() {
		return  emf.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity) { // Retorna a primay key
		return emf.getPersistenceUnitUtil().getIdentifier(entity);
	}

}
