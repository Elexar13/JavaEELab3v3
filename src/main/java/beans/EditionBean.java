package beans;


import dao.EditionDAO;
import entities.Edition;
import entities.Recipient;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
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

    public List<Integer> getSelectedId(){
        return editionDAO.selectEditionId();
    }

    public void updateEdition(Edition edition){
        editionDAO.update(edition);
    }

    public void deleteEdition(int id){
        editionDAO.delete(id);
    }

    public void addEdition(Edition edition){
        editionDAO.add(edition);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
