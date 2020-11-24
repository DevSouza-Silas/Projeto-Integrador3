package br.fvc.pi3.dao;

import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.util.JPAutil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

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


	public List<Usuario> lista() {

		try {
			EntityManager em = JPAutil.getEntityManager();

			@SuppressWarnings("unchecked")
			List<Usuario> listaUsuario = em.createQuery("select u from Usuario u").getResultList();
			System.out.println(listaUsuario);
			em.close();

			return listaUsuario;

		} catch (Exception e) {
			System.out.println("Erro interno ao tentar inserção! Log: " + e);
		}
		return null;
	}

	public Usuario updateMerge(Usuario usuario) {
		
		EntityManager em = JPAutil.getEntityManager();
		em.getTransaction().begin();
		Usuario entidadeSalva = em.merge(usuario); // O Merge, salva ou atualiza.
		em.getTransaction().commit();

		return entidadeSalva;
	}
	
	public void delete(Usuario usuario){
		EntityManager em = JPAutil.getEntityManager();
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
    public Usuario getUsuario(String login, String senha) {

        try {
			EntityManager em = JPAutil.getEntityManager();
			
			em.getTransaction().begin();
          Usuario usuario = (Usuario) em
           .createQuery(
               "SELECT u from Usuario u where u.login = :login and u.senha = :senha")
           .setParameter("login", login)
           .setParameter("senha", senha).getSingleResult();
          em.close();

          return usuario;
        } catch (NoResultException e) {
              return null;
        }
      }
}
