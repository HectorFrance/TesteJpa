package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Conta {
	
	@Id
	private int numero;
	private double saldo;
	private double limite;
	public Conta(int numero, double saldo, double limite) {
		super();
		this.numero = numero;
		this.saldo = saldo;
		this.limite = limite;
	}

	public Conta() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public void infoConta() {
		System.out.println("Numero: " + getNumero());
		System.out.println("Saldo: R$" + String.format("%.2f", getSaldo()));
		System.out.println("Limite: R$" + String.format("%.2f", getLimite()));
		System.out.println();
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + ", limite=" + limite + "]";
	}
	
	
}
