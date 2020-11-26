package br.fvc.pi3.controller;

import br.fvc.pi3.dao.AluguelDAO;
import br.fvc.pi3.model.Aluguel;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class AluguelBean {
	
	private Aluguel aluguel;
    private List<Aluguel> listaAluguel;
    private AluguelDAO aluguelDAO;
    private boolean editar = false;

    public AluguelBean() {
         aluguel = new Aluguel();
         listaAluguel = new ArrayList<>();
         aluguelDAO = new AluguelDAO();
    }

    public String novo() {
        aluguel = new Aluguel();
        this.editar = false;
        return "";
    }

    public void excluir() {
        listaAluguel.remove(aluguel);
    }


    public String editar() {
        editar = true;
        return "";
    }
    
    public List<Aluguel> listar() {
    	listaAluguel = aluguelDAO.lista();
    	return listaAluguel;
    }
    

    public void salvarAluguel() {
    	
    	if (this.aluguel != null) {
    		this.aluguel.setEntregue("Não");
    		this.aluguel = aluguelDAO.salvar(this.aluguel);
			this.listaAluguel.add(this.aluguel);
			
    		novo();
    		
		}else {
			
			System.out.println("O obj aluguel está nulo!");
		}

      /*  if (editar) {
            this.listaUsuario.set(listaUsuario.indexOf(usuario), usuario);
        } else {
           
            listaUsuario.add(usuario);
        }*/
    }



	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Aluguel> getListaAluguel() {
		return listaAluguel;
	}

	public void setListaAluguel(List<Aluguel> listaAluguel) {
		this.listaAluguel = listaAluguel;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

}
