package br.fvc.pi3.dao;

import br.fvc.pi3.model.Veiculo;

public class VeiculoDao<E> extends DaoGeneric<Veiculo> {
	
	
	public void removerVeiculo(Veiculo veiculo) throws Exception{
		getEntityManager().getTransaction().begin();
		String sqlDeleteVeiculo = "delete from aluguel where id = " + veiculo.getId();
		getEntityManager().createNativeQuery(sqlDeleteVeiculo).executeUpdate();
		getEntityManager().getTransaction().commit();
		
		super.deletarPoId(veiculo);
	}
}
