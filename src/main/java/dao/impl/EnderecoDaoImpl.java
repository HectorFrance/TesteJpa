package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.EnderecoDao;
import model.Endereco;
import model.util.JpaUtil;

public class EnderecoDaoImpl implements EnderecoDao {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.persist(endereco);
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
	public void alterar(Endereco endereco) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.merge(endereco);
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
			em.remove(em.find(Endereco.class, numero));
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
	public Endereco pesquisar(int numero) {
		Endereco endereco = new Endereco();
		try {
			this.em = JpaUtil.getEntityManeger();
			endereco = em.find(Endereco.class, numero);
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

		return endereco;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Endereco> listarTodos() {
		this.em = JpaUtil.getEntityManeger();
		Query query = em.createQuery("from Endereco e");
		List<Endereco> listaEndereco = query.getResultList();
		em.close();
		return listaEndereco;
	}

}
