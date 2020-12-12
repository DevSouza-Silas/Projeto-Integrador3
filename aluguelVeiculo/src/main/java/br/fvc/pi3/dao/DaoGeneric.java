package br.fvc.pi3.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.model.Veiculo;
import br.fvc.pi3.util.JPAutil;

@SuppressWarnings("unchecked")
public class DaoGeneric<E> {
	

	private	EntityManager em = JPAutil.getEntityManager();
	
	
	public Usuario getUsuario(String login, String senha) {

		try {
			EntityManager em = JPAutil.getEntityManager();

			em.getTransaction().begin();
			Usuario usuario = (Usuario) em
					.createQuery("SELECT u from Usuario u where u.login = :login and u.senha = :senha")
					.setParameter("login", login).setParameter("senha", senha).getSingleResult();
			em.close();

			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
	public void salvar(E entidade) {
		EntityTransaction transaction = em.getTransaction(); 
		transaction.begin();
		em.persist(entidade);
		transaction.commit();
	}

	public E updateMerge(E entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		E entidadeSalva = em.merge(entidade);
		transaction.commit();

		return entidadeSalva;
	}

	public E pesquisar(E entidade) {
		Object id = JPAutil.getPrimaryKey(entidade);
		E e = (E) em.find(entidade.getClass(), id);
		return e;
	}

	public E pesquisar(Long id, Class<E> entidade) {
		em.clear();
		E e = (E) em.createQuery("from " + entidade.getSimpleName() + " where id = " + id).getSingleResult();
		return e;
	}
   
	public void deletarPoId(E entidade) throws Exception{
		Object id = JPAutil.getPrimaryKey(entidade); 
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		em.createNativeQuery("delete from " + entidade.getClass()
		  .getSimpleName().toLowerCase() + " where id =" + id)
			.executeUpdate(); 
		transaction.commit();
	}
	
	public List<SelectItem> listaVeiculos(Veiculo veiculo){
		
		List<SelectItem> selectItems = new ArrayList<SelectItem>();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Veiculo> lista = em.createQuery("from " + veiculo).getResultList();
		transaction.commit();
		
		
		for (Veiculo veiculo1 : lista) {
			selectItems.add(new SelectItem(veiculo1, veiculo1.getFabricante()));
		}
		
		return selectItems;
	} 
	
	public List<E> listar(Class<E> entidade) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		List<E> lista = em.createQuery("from " + entidade.getName()).getResultList();
		transaction.commit();

		return lista;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}

}
