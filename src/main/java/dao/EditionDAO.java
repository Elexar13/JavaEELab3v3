package dao;


import entities.Edition;
import entities.Order;
import entities.Recipient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class EditionDAO {

    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Edition> findAll(){
        return em.createNamedQuery("Edition.findAll", Edition.class).getResultList();
    }

    public void update(Edition edition){
        if (edition.getName()!=null | !edition.getName().equals("")){
            Query query = em.createQuery("update Edition e SET e.name = :name WHERE e.id = :id");
            query.setParameter("name", edition.getName());
            query.setParameter("id", edition.getId());
            query.executeUpdate();
        }
        if (edition.getCity()!=null | !edition.getCity().equals("")){
            Query query = em.createQuery("update Edition e SET e.city = :city WHERE e.id = :id");
            query.setParameter("city", edition.getCity());
            query.setParameter("id", edition.getId());
            query.executeUpdate();
        }
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public void delete(int id){
        Query query = em.createQuery("DELETE FROM Edition e WHERE e.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
        em.createNamedQuery("Order.findAll", Order.class).getResultList();
    }

    public List<Integer> selectEditionId() {
        return em.createQuery("select e.id from Edition e").getResultList();
    }

    public void add(Edition edition) {
        em.persist(edition);
    }
}
