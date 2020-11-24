package br.fvc.pi3.dao;

import br.fvc.pi3.model.Aluguel;
import br.fvc.pi3.util.JPAutil;

import java.util.List;

import javax.persistence.EntityManager;

public class AluguelDAO {
	
	public Aluguel salvar(Aluguel aluguel) {
		
		try {
			EntityManager em = JPAutil.getEntityManager();
			
			em.getTransaction().begin();
			em.merge(aluguel);
			em.getTransaction().commit();

			System.out.println("Salvo com sucesso!");
			em.close();


		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção!");
		}
		return aluguel;

	}
	
	public List<Aluguel> lista() {
		
		try {
			EntityManager em = JPAutil.getEntityManager();

			@SuppressWarnings("unchecked")
			List<Aluguel>	listaAluguel = em.createQuery("select u from Aluguel u").getResultList();
				
			em.close();

			return	listaAluguel;

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção! Log: "+e);
		}
		return null;	
	}

}
