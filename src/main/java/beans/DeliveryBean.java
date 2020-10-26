package beans;

import dao.DeliveryDAO;
import dao.RecipientDAO;
import entities.Delivery;
import entities.Recipient;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class DeliveryBean implements Serializable {
    @EJB
    private DeliveryDAO deliveryDAO;

    private Delivery delivery = new Delivery();

    public Delivery getDelivery() {
        return delivery;
    }

    public List<Delivery> getDeliveries(){
        return deliveryDAO.findAll();
    }

    public void updateDelivery(int id){
        deliveryDAO.update();
    }

    public void deleteDelivery(int id){
        deliveryDAO.delete();
    }
}
