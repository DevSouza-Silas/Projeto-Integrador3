package br.fvc.pi3.dao;

import br.fvc.pi3.model.Aluguel;

public class AluguelDao<E> extends DaoGeneric<Aluguel> {

	public void removerVeiculo(Aluguel aluguel) throws Exception{
		getEntityManager().getTransaction().begin();
		String sqlDeleteVeiculo = "delete from aluguel where id = " + aluguel.getId();
		getEntityManager().createNativeQuery(sqlDeleteVeiculo).executeUpdate();
		getEntityManager().getTransaction().commit();
	}
}
