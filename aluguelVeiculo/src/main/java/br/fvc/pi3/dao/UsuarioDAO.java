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

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserir no banco!");
		}
		return usuario;

	}

	
	public List<Usuario> listaUser() {
		EntityManager em = JPAutil.getEntityManager();
		return em.createQuery("select u from Usuario" , Usuario.class).getResultList();
	}
	
	public List<Usuario> lista() {
		
		try {
			EntityManager em = JPAutil.getEntityManager();

			@SuppressWarnings("unchecked")
			List<Usuario> listaUsuario = em.createQuery("select u from Usuario u").getResultList();
			System.out.println(listaUsuario);	
			em.close();

			return	listaUsuario;

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção! Log: "+e);
		}
		return null;	
	}
}
