package br.org.catolicasc.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.org.catolicasc.model.Automovel;

public class AtualizadorDeAutomovel {

	public static void main(String[] args) {
		
		//Fabrica de gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");	

		//Gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		Automovel auto = em.getReference(Automovel.class, 2L);
		
		// Gravar Auto
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(auto);
		transaction.commit();
		em.close();
		emf.close();
	}
}
