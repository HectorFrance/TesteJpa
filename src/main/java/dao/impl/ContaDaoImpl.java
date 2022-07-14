package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.ContaDao;
import model.Conta;
import model.util.JpaUtil;

public class ContaDaoImpl implements ContaDao {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(model.Conta conta) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.persist(conta);
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
	public void alterar(model.Conta conta) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.merge(conta);
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
	public void remover(int numero) {

		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Conta.class, numero));
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
	public model.Conta pesquisar(int numero) {
		Conta conta = new Conta();
		try {
			this.em = JpaUtil.getEntityManeger();
			conta = em.find(Conta.class, numero);
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

		return conta;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<model.Conta> listarTodos() {
		this.em = JpaUtil.getEntityManeger();
		Query query = em.createQuery("from Conta c");
		List<Conta> listaConta = query.getResultList();
		em.close();
		return listaConta;
	}

}
