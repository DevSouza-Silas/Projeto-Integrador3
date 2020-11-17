package br.fvc.pi3.ontroller;

import br.fvc.pi3.dao.UsuarioDAO;
import br.fvc.pi3.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Silas Souza
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private UsuarioDAO usuarioDAO;
    private boolean editar = false;

    public UsuarioBean() {
         usuario = new Usuario();
         listaUsuario = new ArrayList<>();
         usuarioDAO = new UsuarioDAO();
    }

    public String novo() {
        usuario = new Usuario();
        this.editar = false;
        return "";
    }

    public void excluir() {
        listaUsuario.remove(usuario);
    }


    public String editar() {
        editar = true;
        return "";
    }
    
    public List<Usuario> listar() {
    	listaUsuario = usuarioDAO.lista();
    	return listaUsuario;
    }
    

    public void salvarUsuario() {
    	
    	if (this.usuario != null) {
			
    		this.usuario = usuarioDAO.salvar(this.usuario);
			this.listaUsuario.add(this.usuario);
			
    		novo();
    		
		}else {
			
			System.out.println("O obj usuário está nulo!");
		}

      /*  if (editar) {
            this.listaUsuario.set(listaUsuario.indexOf(usuario), usuario);
        } else {
           
            listaUsuario.add(usuario);
        }*/
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

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	
}
