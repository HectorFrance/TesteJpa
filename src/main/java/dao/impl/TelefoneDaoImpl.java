package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.TelefoneDao;
import model.Telefone;
import model.util.JpaUtil;

public class TelefoneDaoImpl implements TelefoneDao{
	
	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void salvar(Telefone telefone) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.persist(telefone);
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
	public void alterar(Telefone telefone) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.merge(telefone);
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
	public void remover(long l) {
		try {
			this.em = JpaUtil.getEntityManeger();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Telefone.class, l));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				System.out.println(e.getMessage());
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
	public Telefone pesquisar(long numero) {
		Telefone telefone = new Telefone();
		try {
			this.em = JpaUtil.getEntityManeger();
			telefone = em.find(Telefone.class, numero);
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

		return telefone;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Telefone> listarTodos() {
		this.em = JpaUtil.getEntityManeger();
		Query query = em.createQuery("from Telefone t");
		List<Telefone> listaTelefone = query.getResultList();
		em.close();
		return listaTelefone;
	}

}
