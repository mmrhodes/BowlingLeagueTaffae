package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;


public class PlayerHelper {
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueTaffae");

	public void insertPlayer(Player toAdd) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();

	}

	public List<Player> viewAllPlayers() {



		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select li from Player li", Player.class);
		List<Player> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}
 
	public void deleteItem(Player itemToDelete) {
		 	
	}
}
