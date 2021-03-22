package br.org.catolicasc.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.org.catolicasc.model.Automovel;

public class PersistidorDeAutomovel {

	public static void main(String[] args) {
		
		//Fabrica de gerenciador de entidades
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");	

		//Gerenciador de entidades
		EntityManager em = emf.createEntityManager();
		
		//Criar auto
		Automovel auto = new Automovel();
		auto.setMarca("VW");
		auto.setModelo("Jetta");
		auto.setObservacoes("RLine 1.4 Turbo");
		auto.setAnoFabricacao(2020);
		
		// Gravar Auto
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(auto);
		transaction.commit();
		em.close();
		emf.close();
	}
}
