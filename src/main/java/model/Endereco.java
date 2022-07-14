package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Endereco {

	@Id
	@Column(name = "ID_ENDERECO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO")
	@SequenceGenerator(name = "ENDERECO", sequenceName = "S_ID_ENDERECO", allocationSize = 1, initialValue = 100)
	private int id;
	private String rua, complemento;
	private int numero;

	public Endereco(String rua, String complemento, int numero) {
		super();
		this.rua = rua;
		this.complemento = complemento;
		this.numero = numero;
	}

	public Endereco() {
		super();
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIdEndereco() {
		return id;
	}

	public void setIdEndereco(int idEndereco) {
		this.id = idEndereco;
	}

	public void infoEndereco() {
		System.out.println("Id: " + getIdEndereco());
		System.out.println("Rua: " + getRua());
		System.out.println("Numero: " + getNumero());
		System.out.println("Complemento: " + getComplemento());
		System.out.println();
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", complemento=" + complemento + ", numero=" + numero + ", idEndereco=" + id
				+ "]";
	}

}
