package br.fvc.pi3.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.fvc.pi3.model.Veiculo;
import br.fvc.pi3.dao.VeiculoDao;

@ManagedBean
@ViewScoped
public class VeiculoBean {

	private Veiculo veiculo = new Veiculo();
	private List<Veiculo> listVeiculo = new ArrayList<Veiculo>();
	private VeiculoDao<Veiculo> veiculoDao = new VeiculoDao<Veiculo>();
	private List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	public VeiculoBean() {
		//listVeiculo = veiculoDao.listar(Veiculo.class);
		//veiculo = veiculoDao.pesquisar(veiculo.getId(), Veiculo.class);
		//this.veiculo = veiculoDao.pesquisar(getVeiculo());
		
	}
	
	public List<SelectItem> getSelectItems() {
		
		selectItems = veiculoDao.listaVeiculos(veiculo);
		return selectItems;
	}
	
	public String salvar() {
		this.veiculo = veiculoDao.updateMerge(veiculo);
		this.novo();
		this.getList();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cliente salvo com sucesso!"));
		return "";
	}
	
	public String editar() {
		this.veiculo = veiculoDao.pesquisar(this.veiculo.getId(), Veiculo.class);
		return "cadastroCliente";
	}

	public String novo() {
		veiculo = new Veiculo();
		return "";
	}

	public List<Veiculo> getList() {
		listVeiculo = veiculoDao.listar(Veiculo.class);
		return listVeiculo;
	}

		
	public String remover() throws Exception {

		veiculoDao.removerVeiculo(veiculo);
		this.novo();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Cliente removido com sucesso!"));

		return "";
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

}
