package beans;


import dao.RecipientDAO;
import entities.Recipient;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
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

    public void updateRecipient(int id){
        recipientDAO.update();
    }

    public void deleteRecipient(int id){
        recipientDAO.delete();
    }
}
