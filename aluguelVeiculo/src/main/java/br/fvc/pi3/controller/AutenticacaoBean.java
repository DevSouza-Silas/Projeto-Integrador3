package br.fvc.pi3.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.fvc.pi3.dao.UsuarioDao;
import br.fvc.pi3.model.Usuario;

@ManagedBean
public class AutenticacaoBean {

	private Usuario usuarioLogado;
	private Usuario usuario;
	private UsuarioDao<Usuario> usuarioDAO;

	public AutenticacaoBean() {
		usuarioLogado = new Usuario();
		usuario = new Usuario();
		usuarioDAO = new UsuarioDao<Usuario>();
	}

	public String logarSistema() {
		
		usuarioLogado = usuarioDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário invalido!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		} else {
			novo();
			return "/home";
		}

	}
	

	public String novo() {
		this.usuario = new Usuario();
		return "";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
	
}
