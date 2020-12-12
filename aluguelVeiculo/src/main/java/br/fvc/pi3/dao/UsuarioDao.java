package br.fvc.pi3.dao;

import br.fvc.pi3.model.Usuario;

/**
 * @author Silas Souza
 */
public class UsuarioDao<E> extends DaoGeneric<Usuario> {

	public void removerUsario(Usuario usuario) throws Exception {
		getEntityManager().getTransaction().begin();
		String sqlDeletaUsuario = "delete from aluguel where id = " + usuario.getId();
		getEntityManager().createNativeQuery(sqlDeletaUsuario).executeUpdate();
		getEntityManager().getTransaction().commit();

		super.deletarPoId(usuario);
	}
}
