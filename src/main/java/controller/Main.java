package controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.impl.ContaDaoImpl;
import dao.impl.EnderecoDaoImpl;
import dao.impl.PessoaDaoImpl;
import dao.impl.TelefoneDaoImpl;
import model.Conta;
import model.Endereco;
import model.Pessoa;
import model.Telefone;
import model.TipoTelefoneUnum;

public class Main {

	public static void main(String[] args) {

//		ContaDaoImpl cdi = new ContaDaoImpl();
//		EnderecoDaoImpl edi = new EnderecoDaoImpl();
//		PessoaDaoImpl pdi = new PessoaDaoImpl();
//		TelefoneDaoImpl tpi = new TelefoneDaoImpl();
//		
//		
//		System.out.println("batata");
//		Endereco e = new Endereco("Rua jesu", "casa", 40);
//		Conta c = new Conta(555, 2000, 500);
//		Pessoa p = new Pessoa("M", "70651616718", "Heitor Franca", 21, e, c);
//
//		Telefone t = new Telefone(81994919920l, TipoTelefoneUnum.Celualr,p);
//		Telefone t2 = new Telefone(8132669350l, TipoTelefoneUnum.Residencial,p);
//		
//		tpi.salvar(t2);
		
		System.out.println("Iniciando");
		try {
			 EntityManagerFactory factory = Persistence.createEntityManagerFactory("testeHibernate");
			 System.out.println(factory);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("tentando conectar");
		
	}

}
