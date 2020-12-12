package teste;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.fvc.pi3.model.Veiculo;
import br.fvc.pi3.util.JPAutil;

public class Teste {
	
	public static void main(String []args) {
		
		Veiculo veiculo = new Veiculo();
		
		veiculo.setModelo("teste2020");
		veiculo.setPlaca("teste2020");
		veiculo.setAno(2020);
		veiculo.setNumero(2020);
		
		System.out.println(listaVeiculos(veiculo));
		
	}
	
	
	
	private static	EntityManager em = JPAutil.getEntityManager();

	@SuppressWarnings("unchecked")
	public static List<SelectItem> listaVeiculos(Veiculo veiculo){
		
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
}
