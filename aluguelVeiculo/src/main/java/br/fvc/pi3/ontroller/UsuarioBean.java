package br.fvc.pi3.ontroller;

import br.fvc.pi3.dao.UsuarioDAO;
import br.fvc.pi3.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 * @author Silas Souza
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private List<Usuario> usuarios;
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

	public String remover(){
		usuarioDAO.delete(usuario);
		this.getUsuarios();
		return "";
	}

	public String editar() {

		this.usuario = usuarioDAO.updateMerge(usuario);
		
		return "cadastroUsuario";
	}

	public String salvarUsuario() {

		if (this.usuario != null) {

			this.usuario = usuarioDAO.salvar(this.usuario);

		} else {

			System.out.println("O objeto usuário está nulo!");
		}
		return null;

		/*
		 * if (editar) { this.listaUsuario.set(listaUsuario.indexOf(usuario), usuario);
		 * } else {
		 * 
		 * listaUsuario.add(usuario); }
		 */
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		usuarios = usuarioDAO.lista();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	

}
