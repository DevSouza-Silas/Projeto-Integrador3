package br.fvc.pi3.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Veiculo implements Serializable {
	/**
	 * @author Silas Souza
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fabricante;
	private Integer numero;
	private String modelo;
	private Integer ano;
	private String placa;
	private String arcondicionado;
	private String travasEletrica;
	private String direcaoHidraulica;
	private String multimidia;
	
	@OneToMany(mappedBy = "veiculo", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<Aluguel> listaAluguel;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getArcondicionado() {
		return arcondicionado;
	}

	public void setArcondicionado(String arcondicionado) {
		this.arcondicionado = arcondicionado;
	}

	public String getTravasEletrica() {
		return travasEletrica;
	}

	public void setTravasEletrica(String travasEletrica) {
		this.travasEletrica = travasEletrica;
	}

	public String getDirecaoHidraulica() {
		return direcaoHidraulica;
	}

	public void setDirecaoHidraulica(String direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}

	public String getMultimidia() {
		return multimidia;
	}

	public void setMultimidia(String multimidia) {
		this.multimidia = multimidia;
	}

	public List<Aluguel> getListaAluguel() {
		return listaAluguel;
	}

	public void setListaAluguel(List<Aluguel> listaAluguel) {
		this.listaAluguel = listaAluguel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
