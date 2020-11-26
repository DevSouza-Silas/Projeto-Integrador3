package br.fvc.pi3.controller;

import br.fvc.pi3.dao.UsuarioDAO;
import br.fvc.pi3.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * @author Silas Souza
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Usuario> listaUsuario;
	private UsuarioDAO usuarioDAO;

	public UsuarioBean() {
		usuario = new Usuario();
		usuarios = new ArrayList<Usuario>();
		usuarioDAO = new UsuarioDAO();
	}

	public String novo() {
		this.usuario = new Usuario();
		this.usuarios.clear();
		return "";
	}

	public String remover() {
		usuarioDAO.delete(usuario);
		this.getUsuarios();
		return "";
	}

	public String editar() {

		this.usuario = usuarioDAO.update(usuario);

		return "cadastroUsuario";
	}

	public void salvar() {

		if (this.usuario != null) {

			usuarioDAO.inserir(this.usuario);
			this.novo();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário está nulo!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println("");
		}
	}

	public String getEnviar() {

		usuario = usuarioDAO.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuario == null) {
			usuario = new Usuario();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário inválido!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			return null;
		} else {
			novo();
			return "/home";
		}

	}

	public List<SelectItem> getListUsuarioo() {
		List<SelectItem> list = new ArrayList<SelectItem>();
		listaUsuario = usuarioDAO.listar();

		for (Usuario usuario : listaUsuario) {
			list.add(new SelectItem(usuario, usuario.getNome()));
		}
		return list;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		usuarios = usuarioDAO.listar();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
