package dao;

import entities.Edition;
import entities.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class OrderDAO {

    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Order> findAll(){
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void update(){

    }

    public void delete(){

    }
}
