package br.fvc.pi3.dao;

import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.util.JPAutil;

import java.util.List;

import javax.persistence.EntityManager;
/**
 * @author Silas Souza
 */
public class UsuarioDAO extends JPAutil {

	public Usuario salvar(Usuario usuario) {
		
		try {
			EntityManager em = JPAutil.getEntityManager();
			
			em.getTransaction().begin();
			em.merge(usuario);
			em.getTransaction().commit();

			System.out.println("Salvo com sucesso!");
			em.close();
			emf.close();

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção!");
		}
		return usuario;

	}
	
	public List<Usuario> lista() {
		
		try {
			EntityManager em = JPAutil.getEntityManager();

			@SuppressWarnings("unchecked")
			List<Usuario>	listaUsuario = em.createQuery("select u from Usuario u").getResultList();
				
			em.close();
			emf.close();

			return	listaUsuario;

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção! Log: "+e);
		}
		return null;	
	}
}
