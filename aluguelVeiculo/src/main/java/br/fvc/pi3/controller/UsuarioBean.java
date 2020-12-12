package br.fvc.pi3.controller;

import br.fvc.pi3.dao.UsuarioDao;
import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 * @author Silas Souza
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private List<Usuario> list = new ArrayList<Usuario>();
	private UsuarioDao<Usuario> daoGeneric = new UsuarioDao<Usuario>();
	private BarChartModel barCharModel = new BarChartModel();

	@PostConstruct
	public void init() {
		list = daoGeneric.listar(Usuario.class);
	}

	public BarChartModel getBarCharModel() {
		return barCharModel;
	}

	public String salvar() {
		this.usuario = daoGeneric.updateMerge(this.usuario);
		this.novo();
		this.getList();

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Usuário salvo com sucesso!"));
		return "";
	}
	
	public String editar() {
		this.usuario = daoGeneric.pesquisar(this.usuario.getId(), Usuario.class);
		return "primefaces";
	}

	public String novo() {
		this.usuario = new Usuario();
		return "";
	}

	
	public String remover() throws Exception {

		daoGeneric.removerUsario(this.usuario);
		this.novo();
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Usuário removido com sucesso!"));

		return "";
	}

	public List<Usuario> getList() {
		list = daoGeneric.listar(Usuario.class);
		return list;
	}
	
	public void setList(List<Usuario> list) {
		this.list = list;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
