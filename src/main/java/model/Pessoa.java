package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pessoa {

	@Id
	private String cpf;
	private String nome;
	private String sexo;
	private int idade;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID_ENDERECO")
	private Endereco endereco;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUMERO_CONTA", referencedColumnName = "NUMERO")
	private Conta conta;
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Telefone> listaTelefones = new ArrayList<Telefone>();

	public Pessoa(String sexo, String cpf, String nome, int idade, Endereco endereco, Conta conta) {
		super();
		this.sexo = sexo;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.endereco = endereco;
		this.conta = conta;
	}

	public Pessoa() {
		super();
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setListaTelefones(List<Telefone> l) {
		this.listaTelefones = l;
	}

	public List<Telefone> getListaTelefones() {
		return this.listaTelefones;
	}

	public void infoPessoa() {
		System.out.println("Nome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("Sexo: " + getSexo());
		System.out.println("idade: " + getIdade());
		getEndereco().infoEndereco();
		getConta().infoConta();
		System.out.println();
	}

	@Override
	public String toString() {
		return "Pessoa [sexo=" + sexo + ", cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", endereco="
				+ endereco + ", conta=" + conta + "]";
	}

}
