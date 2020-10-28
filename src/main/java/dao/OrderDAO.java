package dao;

import entities.Edition;
import entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class OrderDAO {

    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Order> findAll(){
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id) {
        Query query = em.createQuery("DELETE FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }
}
