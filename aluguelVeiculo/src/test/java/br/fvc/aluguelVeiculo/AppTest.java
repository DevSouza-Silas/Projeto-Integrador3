package br.fvc.aluguelVeiculo;

import java.util.List;

import javax.persistence.EntityManager;
import br.fvc.pi3.model.*;
import br.fvc.pi3.util.JPAutil;

public class AppTest extends JPAutil {
	
	public static void main(String[] args) {
		
			/*
			try {
				Usuario usuario = new Usuario(null,"dfsdfdsf", "dssfcsf", "DFSADF@dfgvdg", "dfsfs", "2154");
				
				EntityManager em = JPAutil.getEntityManager();

				em.getTransaction().begin();
				em.persist(usuario);
				em.getTransaction().commit();

				System.out.println("Salvo com sucesso!");
				em.close();
				emf.close();

			} catch (Exception e) {
				System.out.println("Erro interno ao tentar inserção!");
			}

		
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluguelVeiculo");
		EntityManager em = emf.createEntityManager();

		Usuario u = em.find(Usuario.class, 2); 

		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		
		System.out.println("Removido com sucesso!");

		em.close();
		emf.close();
		*/
		
		/* -----------------------------------------------------------------------
		EntityManager em = JPAutil.getEntityManager();

		Usuario u = new Usuario(); 
		u = em.find(Usuario.class, 1); 
		
		System.out.println("Retorno da consulta: "+u);

		em.close();
		emf.close();
		----------------------------------------------------------*/
		
		
		EntityManager em = JPAutil.getEntityManager();
			
		@SuppressWarnings("unchecked")
		List<Usuario>	listaUsuario = em.createQuery("select u from Usuario u").getResultList();
			
		em.close();
		emf.close();

		System.out.println("Retorno da consulta: "+listaUsuario);
		
		
		/* --------------------------------------------------------------------------
		Usuario usuario = new Usuario(null, "dfgdfg", "admin", "dfgdfg@gmail.com", "souza", "123"); 
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("aluguelVeiculo");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		System.out.println("Salvo com sucesso!");
		em.close();
		emf.close();
		*/
	} 
}
