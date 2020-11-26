package br.fvc.pi3.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.fvc.pi3.model.Cliente;
import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.util.JPAutil;

/**
 * @author Silas Souza
 *
 */
public class ClienteDao {

	public Cliente inserir(Cliente cliente) {

		try {
			EntityManager em = JPAutil.getEntityManager();

			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();

			System.out.println("Salvo com sucesso!");
			em.close();

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserir no banco!");
		}
		return cliente;
	}

	public List<Usuario> listar() {

		try {
			EntityManager em = JPAutil.getEntityManager();

			@SuppressWarnings("unchecked")
			List<Usuario> listaCliente = em.createQuery("select u from Usuario u").getResultList();
			System.out.println(listaCliente);
			em.close();


		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção! Log: " + e);
		}
		return null;
	}

	public Cliente update(Cliente cliente) {

		EntityManager em = JPAutil.getEntityManager();
		em.getTransaction().begin();
		Serializable entidade = em.merge(cliente);
		em.getTransaction().commit();

		return (Cliente) entidade;
	}

	public void delete(Cliente cliente) {

		EntityManager em = JPAutil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.getReference(Usuario.class, cliente.getId()));
		em.getTransaction().commit();
		em.close();
	}

}
