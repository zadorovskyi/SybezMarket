package org.sybez.dao.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.sybez.dao.service.CategorySecondLevelService;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		//System.out.println(em.createQuery("Select p.categoryFirstLevelName from CategoryFirstLevel p where p.categoryFirstLevelName =:name ").setParameter("name", "wfd").getResultList());
		//System.out.println(em.createQuery("Select p.categorySecondLevelName from CategorySecondLevel p Join p.categoryFirstLevel first where first.categoryFirstLevelName =:name ").setParameter("name", "wfd").getResultList());
		System.out.println(em.createQuery("select cat.categoryFirstLevelName from CategoryFirstLevel cat").getResultList());
		System.out.println(em.createQuery("select p.productName from Product p join p.categorySecondLevel catsec join catsec.categoryFirstLevel catfirst where catfirst.id =:id").setParameter("id",1).getResultList());
		CategoryFirstLevel cat = new CategoryFirstLevel();;
		String name = "second";
			cat = (CategoryFirstLevel) em.createQuery("Select pe from CategoryFirstLevel p where p.categoryFirstLevelName =: name").setParameter("name", name).getSingleResult();
			CategorySecondLevel catSec = new CategorySecondLevel();
			catSec.setCategoryFirstLevel(cat);
			em.persist(catSec);
			Product newProd = new Product();
			newProd.setProductName("vafel");
			newProd.setProductPrice(150);
			newProd.setCategorySecondLevel(catSec);
			em.persist(newProd);
			em.remove(em.find(Product.class , 1));
		
		/*Client client = new Client();
		ClientName clientName;
		try{
		clientName = (ClientName) em.createQuery("select p from clientName p where p.clientName =:name").setParameter("name", "first").getSingleResult();}catch(NoResultException e){
			clientName = new ClientName();
			clientName.setClientName("Petro");
		}
		client.setClientName(clientName);
		
		
		System.out.println(em.createQuery("select p from Product p join p.products cat where cat.categorySecondLevelName =:name").setParameter("name", "wfd").getResultList());*/
		em.getTransaction().commit();
		em.close();
		factory.close();

	}
}
