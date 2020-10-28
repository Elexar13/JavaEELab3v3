package dao;

import entities.Order;
import entities.Recipient;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

@Stateless
public class RecipientDAO {
    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Recipient> findAll(){
        return em.createNamedQuery("Recipient.findAll", Recipient.class).getResultList();
    }

    public void update(Recipient recipient) {
        if (recipient.getName()!=null | !recipient.getName().equals("")){
            Query query = em.createQuery("update Recipient r SET r.name = :name WHERE r.id = :id");
            query.setParameter("name", recipient.getName());
            query.setParameter("id", recipient.getId());
            query.executeUpdate();
        }
        if (recipient.getAddress()!=null | !recipient.getAddress().equals("")){
            Query query = em.createQuery("update Recipient r SET r.address = :address WHERE r.id = :id");
            query.setParameter("address", recipient.getAddress());
            query.setParameter("id", recipient.getId());
            query.executeUpdate();
        }
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM Recipient r WHERE r.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectRecipientId() {
        return em.createQuery("select r.id from Recipient r").getResultList();
    }

    public void add(Recipient recipient) {
            em.persist(recipient);
    }
}
