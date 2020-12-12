package br.fvc.pi3.dao;

import br.fvc.pi3.model.Cliente;

public class ClienteDao<E> extends DaoGeneric<Cliente> {
	
	
	public void removerCliente(Cliente pessoa) throws Exception{
		getEntityManager().getTransaction().begin();
		String sqlDeleteAluguel = "delete from aluguel where id = " + pessoa.getId();
		getEntityManager().createNativeQuery(sqlDeleteAluguel).executeUpdate();
		getEntityManager().getTransaction().commit();
		
		super.deletarPoId(pessoa);
	}

}
