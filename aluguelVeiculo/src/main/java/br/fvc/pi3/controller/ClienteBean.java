package br.fvc.pi3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.fvc.pi3.model.Cliente;
import br.fvc.pi3.dao.ClienteDao;

@ManagedBean
@ViewScoped
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private List<Cliente> list = new ArrayList<Cliente>();
	private ClienteDao<Cliente> daoGeneric = new ClienteDao<Cliente>();

	public  ClienteBean() {
		list = daoGeneric.listar(Cliente.class);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String salvar() {
		this.cliente = daoGeneric.updateMerge(cliente);
		this.novo();
		this.getList();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
		return "";
	}
	
	public String editar() {
		this.cliente = daoGeneric.pesquisar(this.cliente.getId(), Cliente.class);
		return "cadastroCliente";
	}

	public String novo() {
		cliente = new Cliente();
		return "";
	}

	public List<Cliente> getList() {
		list = daoGeneric.listar(Cliente.class);
		return list;
	}

	public String remover() throws Exception {

		daoGeneric.removerCliente(cliente);
		this.novo();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cliente removido com sucesso!"));

		return "";
	}
}
