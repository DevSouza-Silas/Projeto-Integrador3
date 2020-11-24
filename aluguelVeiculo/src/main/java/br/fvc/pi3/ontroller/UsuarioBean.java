package br.fvc.pi3.ontroller;

import br.fvc.pi3.dao.UsuarioDAO;
import br.fvc.pi3.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Silas Souza
 */
@ManagedBean
@ViewScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO usuarioDAO;
    private String destinoSalvar;

    public UsuarioBean() {
         usuario = new Usuario();
         usuarios = new ArrayList<Usuario>();
         usuarioDAO = new UsuarioDAO();
    }

    public String novo() {
        usuario = new Usuario();
        return "";
    }

    public void excluir() {
    	usuarios.remove(usuario);
    }


    public String getEditar() {
        return "cadastroUsuario";
    }
    
    public void salvarUsuario() {
    	
    	if (this.usuario != null) {
			
    		this.usuario = usuarioDAO.salvar(this.usuario);
    		this.usuarios.add(this.usuario);
    		this.usuario = new Usuario();
    		
		}else {
			
			System.out.println("O objeto usuário está nulo!");
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
    
   
	public List<Usuario> getUsuarios() {
		usuarios = usuarioDAO.lista();
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	
}
