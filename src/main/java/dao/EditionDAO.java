package dao;


import entities.Edition;
import entities.Recipient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EditionDAO {

    @PersistenceContext(name = "printedEditionUnit")
    private EntityManager em;

    public List<Edition> findAll(){
        return em.createNamedQuery("Edition.findAll", Edition.class).getResultList();
    }

    public void update(){

    }

    public void delete(){

    }
}
