package br.fvc.pi3.controller;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.fvc.pi3.dao.ClienteDao;
import br.fvc.pi3.model.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private List<Cliente> listaCliente;
	private ClienteDao clienteDAO;

	public ClienteBean() {
		cliente = new Cliente();
		listaCliente = new ArrayList<Cliente>();
		clienteDAO = new ClienteDao();
	}

	public String novo() {
		this.cliente = new Cliente();
		this.listaCliente.clear();
		return "";
	}
   
	public String remover() {
		
		clienteDAO.delete(cliente);
		return "";
	}

	public String editar() {

		this.cliente = clienteDAO.update(cliente);

		return "cadastroUsuario";
	}

	public String salvar() {

		if (this.cliente != null) {
			
			clienteDAO.inserir(cliente);			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário está nulo!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("");
		}
		
		return null;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		

}
