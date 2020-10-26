package beans;


import dao.EditionDAO;
import entities.Edition;
import entities.Recipient;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class EditionBean implements Serializable {
    @EJB
    private EditionDAO editionDAO;

    private Edition edition = new Edition();

    public Edition getEdition() {
        return edition;
    }

    public List<Edition> getEditions(){
        return editionDAO.findAll();
    }

    public void updateEdition(int id){
        editionDAO.update();
    }

    public void deleteEdition(int id){
        editionDAO.delete();
    }
}
