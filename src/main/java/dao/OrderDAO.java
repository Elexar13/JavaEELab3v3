package dao;

import entities.Edition;
import entities.Order;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class OrderDAO {

    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;
    @EJB
    private RecipientDAO recipientDAO;
    @EJB
    private EditionDAO editionDAO;
    @EJB
    private DeliveryDAO deliveryDAO;

    public List<Order> findAll(){
        return em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id) {
        Query query = em.createQuery("DELETE FROM Order o WHERE o.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectRecipientId() {
        return recipientDAO.selectRecipientId();
    }

    public List<Integer> selectEditionId() {
        return editionDAO.selectEditionId();
    }

    public List<Integer> selectDeliveryId() {
        return deliveryDAO.selectDeliveryId();
    }

    public void add(Order order) {
        em.persist(order);
    }
}
