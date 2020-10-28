package beans;


import dao.RecipientDAO;
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
public class RecipientBean implements Serializable {
    @EJB
    private RecipientDAO recipientDAO;

    private Recipient recipient = new Recipient();

    public Recipient getRecipient() {
        return recipient;
    }

    public List<Recipient> getRecipients(){
        return recipientDAO.findAll();
    }

    public List<Integer> getSelectedId(){
        return recipientDAO.selectRecipientId();
    }

    public void updateRecipient(Recipient recipient){
            recipientDAO.update(recipient);
    }

    public void addRecipient(Recipient recipient){
        recipientDAO.add(recipient);
    }

    public void deleteRecipient(int id){
        recipientDAO.delete(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
