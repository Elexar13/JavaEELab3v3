package dao;

import entities.Recipient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RecipientDAO {
    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Recipient> findAll(){
        return em.createNamedQuery("Recipient.findAll", Recipient.class).getResultList();
    }

    public void update(){

    }

    public void delete(){

    }
}
