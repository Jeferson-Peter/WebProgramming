package br.org.catolicasc.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.org.catolicasc.model.Automovel;

public class ListarAutomovel {

	public static void main(String[] args) {
		
		//Gerenciador de entidades
		EntityManager em = Persistence.createEntityManagerFactory("default").createEntityManager();		
		Query q = em.createQuery(" select a from Automovel a", Automovel.class);
		List<Automovel> autos = q.getResultList();
		for (Automovel automovel : autos) {
			System.out.println(automovel.getModelo());
		}
		
	}
}
