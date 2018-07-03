package dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entities.Panel;

@ApplicationScoped
public class PanelDAO {
	

	//@PersistenceContext(name = "Project")
	//private EntityManager em;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Project");
    EntityManager entitymanager = emfactory.createEntityManager( );
	
	public Panel addPanel(Panel panel) {
		entitymanager.getTransaction().begin(); 
	    entitymanager.persist(panel);
	    entitymanager.getTransaction().commit();
		return panel;
    }
	
	public Panel getById(int id) {
		entitymanager.getTransaction().begin();
		Panel result = entitymanager.find(Panel.class, id);
		entitymanager.getTransaction().commit();
		return result;
	}
	
	public List<Panel> getAll() {
		entitymanager.getTransaction().begin();
		TypedQuery<Panel> query = entitymanager.createQuery("FROM Panel p", Panel.class);
		List<Panel> customer = query.getResultList();
		entitymanager.getTransaction().commit();
    	return customer;
    }
	
	public Panel updatePanel(int id, Panel panel) {
		entitymanager.getTransaction().begin();
		Panel DBCust = entitymanager.find(Panel.class, id);
		if (DBCust == null) {
			entitymanager.getTransaction().rollback();
			return null;
			}
		else {
			panel.setId(id);
			DBCust = entitymanager.merge(panel);
		//entitymanager.persist(DBCust);
			entitymanager.getTransaction().commit();
			return panel;
		}
    }
	
	public Panel deletePanel(int id) {
		entitymanager.getTransaction().begin();
		Panel panel = entitymanager.find(Panel.class, id);
		if (panel == null) {
			entitymanager.getTransaction().rollback();
			return null;
		}
		else {
			entitymanager.remove(panel);
			entitymanager.getTransaction().commit();
			return panel;
		}
    }
/*	public Customer getCustomer(int id) {
		Query query = this.em.createNativeQuery("SELECT * FROM CUSTOMER WHERE id=:IDENT", Customer.class);
    	query.setParameter("IDENT", id);
    	return (Customer) query.getSingleResult();
    }*/
	
	
}
