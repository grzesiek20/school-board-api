package dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import entities.Body;


@ApplicationScoped
public class BodyDAO {

	//@PersistenceContext(name = "Project")
	//private EntityManager em;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Project");
    EntityManager entitymanager = emfactory.createEntityManager( );
    
    @Transactional
	public Body addBody(Body body) {
		//entitymanager.getTransaction().begin(); 
	    entitymanager.persist(body);
	   // entitymanager.getTransaction().commit();
		return body;
    }

    @Transactional
	public Body getById(int id) {
		//entitymanager.getTransaction().begin();
		Body result = entitymanager.find(Body.class, id);
		//entitymanager.getTransaction().commit();
		return result;
	}

    @Transactional
	public List<Body> getAll(){
		entitymanager.getTransaction().begin();
		//TypedQuery<Body> query = entitymanager.createQuery("FROM Body b JOIN Panel p ON p.id=b.panel", Body.class);
		TypedQuery<Body> query = entitymanager.createQuery("FROM Body b", Body.class);
		List<Body> body = null;
		//try {
			body = query.getResultList();
		//}
		//catch(IllegalStateException e)
		//{
		//	entitymanager.getTransaction().rollback();
		//}
		
		//if(body==null) {
		//	entitymanager.getTransaction().rollback();
		//}
		//else {
			entitymanager.getTransaction().commit();
		//}
		
		return body;
		
    }
	
    @Transactional
	public List<Body> getAllByPanelId(int id) {
		//entitymanager.getTransaction().begin();
		TypedQuery<Body> query = entitymanager.createQuery("FROM Body b WHERE Panel=11", Body.class);
		List<Body> body = query.getResultList();
		//entitymanager.getTransaction().commit();
    	return body;
    }
	
    @Transactional
	public Body updateBody(int id, Body body) {
		//entitymanager.getTransaction().begin();
		Body DBBody = entitymanager.find(Body.class, id);
		if (DBBody == null) {
		//	entitymanager.getTransaction().rollback();
			return null;
			}
		else {
			body.setId(id);
			DBBody = entitymanager.merge(body);
		//entitymanager.persist(DBCust);
			//entitymanager.getTransaction().commit();
			return body;
		}
    }
	
    @Transactional
	public Body deleteBody(int id) {
		//entitymanager.getTransaction().begin();
		Body body = entitymanager.find(Body.class, id);
		if (body == null) {
		//	entitymanager.getTransaction().rollback();
			return null;
		}
		else {
			entitymanager.remove(body);
		//	entitymanager.getTransaction().commit();
			return body;
		}
    }
/*	public Customer getCustomer(int id) {
		Query query = this.em.createNativeQuery("SELECT * FROM CUSTOMER WHERE id=:IDENT", Customer.class);
    	query.setParameter("IDENT", id);
    	return (Customer) query.getSingleResult();
    }*/
	
	
}

