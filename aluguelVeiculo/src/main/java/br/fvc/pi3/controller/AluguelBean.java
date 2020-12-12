package br.fvc.pi3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.fvc.pi3.dao.AluguelDao;
import br.fvc.pi3.dao.ClienteDao;
import br.fvc.pi3.dao.VeiculoDao;
import br.fvc.pi3.dao.UsuarioDao;

import br.fvc.pi3.model.Aluguel;
import br.fvc.pi3.model.Cliente;
import br.fvc.pi3.model.Usuario;
import br.fvc.pi3.model.Veiculo;

@ManagedBean
@ViewScoped
public class AluguelBean {

	private Cliente cliente;
	private Aluguel aluguel;
	private Usuario usuario;
	private List<Usuario> listaUsuario;
	private Veiculo veiculo;
	
	private UsuarioDao<Usuario>usuarioDao;
	private ClienteDao<Cliente> clienteDao;
	private AluguelDao<Aluguel> aluguelDao;
	private VeiculoDao<Veiculo> veiculoDao;
	
	public AluguelBean(){
		
		this.cleanFields();
		this.carregarCliente();
	}
	
	public void carregarCliente() {

		String codCli = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap()
				.get("codigoCli");
		
		this.cliente = clienteDao.pesquisar(Long.parseLong(codCli), Cliente.class);
		
		
	}
	
	
	
	public void cleanFields(){
		
		this.cliente = new Cliente();
		this.aluguel = new Aluguel();
		this.usuario = new Usuario();
		this.listaUsuario = new ArrayList<Usuario>();
		this.veiculo = new Veiculo();
		
		this.usuarioDao = new UsuarioDao<Usuario>();
		this.clienteDao = new ClienteDao<Cliente>();
		this.aluguelDao = new AluguelDao<Aluguel>();
		this.veiculoDao = new VeiculoDao<Veiculo>();
	}

	public String salvar(){
		
		//cliente = clienteDao.pesquisar(cliente.getId(), Cliente.class);
		
		aluguel.setCliente(cliente);
		aluguel.setVeiculo(veiculo);
		aluguel.setUsuario(usuario);
		aluguelDao.updateMerge(aluguel);
		
		aluguel = new Aluguel();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Aluguel salvo com sucesso!"));
		return "";
	}
	
	
	
	public String removeAluguel() throws Exception{
		
		aluguelDao.deletarPoId(aluguel);
		
		cliente = clienteDao.pesquisar(cliente.getId(), Cliente.class);
		veiculo = veiculoDao.pesquisar(veiculo.getId(), Veiculo.class);
		usuario = usuarioDao.pesquisar(usuario.getId(), Usuario.class);
		
		aluguel = new Aluguel();
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Aluguel removido com sucesso!"));
		return "";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
}
