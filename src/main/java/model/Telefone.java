package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Telefone {
	@Id
	@Column(name = "ID_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TELEFONE")
	@SequenceGenerator(name = "TELEFONE", sequenceName = "S_ID_TELEFONE", allocationSize = 1, initialValue = 100)
	private long id;
	private long numero;
	@Enumerated(EnumType.STRING)
	private TipoTelefoneUnum tipo;
	@ManyToOne
	@JoinColumn(name = "PESSOA")
	private Pessoa pessoa;

	public Telefone(long numero, TipoTelefoneUnum tipo, Pessoa pessoa) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.pessoa = pessoa;
	}

	public Telefone(long numero, TipoTelefoneUnum tipo) {
		super();
		this.numero = numero;
		this.tipo = tipo;
	}

	public Telefone() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public TipoTelefoneUnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefoneUnum tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + "]";
	}

}
