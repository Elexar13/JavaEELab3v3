package dao;


import entities.Delivery;
import entities.Order;
import entities.Recipient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

@Stateless
public class DeliveryDAO {
    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Delivery> findAll(){
        return em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
    }

    public List<Integer> selectDeliveryId() {
        return em.createQuery("select d.id from Delivery d").getResultList();
    }

    public void update(Delivery delivery){
        if (delivery.getName()!=null | !delivery.getName().equals("")){
            Query query = em.createQuery("update Delivery d SET d.name = :name WHERE d.id = :id");
            query.setParameter("name", delivery.getName());
            query.setParameter("id", delivery.getId());
            query.executeUpdate();
            em.createNamedQuery("Order.findAll", Order.class).getResultList();
        }
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM Delivery d WHERE d.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void add(Delivery delivery) {
        em.persist(delivery);
    }
}
