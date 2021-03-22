package br.org.catolicasc.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.org.catolicasc.model.Automovel;

public class RemovedorDeAutomovel {

	public static void main(String[] args) {
		
		//Fabrica de gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");	

		//Gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		Query q = em.createQuery(" select a from Automovel a ", Automovel.class);
		Automovel auto = (Automovel) q.getResultList().get(0);
		auto.setObservacoes("GLI 2.0 Turbo");
		
		// Gravar Auto
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(auto);
		transaction.commit();
		em.close();
		emf.close();
	}
}
