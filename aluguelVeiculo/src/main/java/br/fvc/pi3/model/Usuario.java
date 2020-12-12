package br.fvc.pi3.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import br.fvc.pi3.model.Aluguel;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 8879017312151040475L;
/**
 * @author Silas Souza
 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;
    private String email;
    private String login;
    private String senha;
    private String sexo;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Aluguel> listaAluguel;
	

    public Usuario() {
    }
    
    public Usuario(Long id, String nome, String cargo, String email, String login, String senha) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
	
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Aluguel> getListaAluguel() {
		return listaAluguel;
	}

	public void setListaAluguel(List<Aluguel> listaAluguel) {
		this.listaAluguel = listaAluguel;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", cargo=" + cargo + ", email=" + email + ", login=" + login
				+ ", senha=" + senha + "]";
	}
    
    
}
