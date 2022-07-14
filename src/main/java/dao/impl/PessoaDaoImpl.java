package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.PessoaDao;
import model.Pessoa;
import model.util.JpaUtil;

public class PessoaDaoImpl implements PessoaDao{
	
	private EntityManager em;
	private EntityTransaction et;
	
	@Override
	public void salvar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.persist(pessoa);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void alterar(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.merge(pessoa);
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void remover(String cpf) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Pessoa.class, cpf));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa pesquisar(String cpf) {
		Pessoa pessoa = new Pessoa();
		try {
			this.em = JpaUtil.getEntityManeger();
			pessoa = em.find(Pessoa.class, cpf);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro na trasação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

		return pessoa;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> listarTodos() {
		this.em = JpaUtil.getEntityManeger();
		Query query = em.createQuery("from Pessoa p");
		List<Pessoa> listaPessoa = query.getResultList();
		em.close();
		return listaPessoa;
	}
	
}
