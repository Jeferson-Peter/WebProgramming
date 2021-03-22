package br.org.catolicasc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.org.catolicasc.model.Automovel;

public class AutomovelDao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");	
	
	public void salvar(Automovel automovel) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(automovel);
		transaction.commit();
		em.close();
	}

	public void atualizar(Automovel automovel) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(automovel);
		transaction.commit();
		em.close();
	}
	
	public void remover(Automovel automovel) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Query q = em.createQuery(" select a from Automovel a ", Automovel.class);
		em.remove(q.getResultList().get(0));
		transaction.commit();
		em.close();
	}
	
	public List<Automovel> listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery(" select a from Automovel a", Automovel.class);
		return q.getResultList();
	}
}
