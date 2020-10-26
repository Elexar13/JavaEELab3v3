package dao;


import entities.Delivery;
import entities.Recipient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class DeliveryDAO {
    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Delivery> findAll(){
        return em.createNamedQuery("Delivery.findAll", Delivery.class).getResultList();
    }

    public void update(){

    }

    public void delete(){

    }
}
