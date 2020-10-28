package beans;

import dao.DeliveryDAO;
import entities.Delivery;


import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
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
    public List<Integer> getSelectedId(){
        return deliveryDAO.selectDeliveryId();
    }

    public void updateDelivery(Delivery delivery){
        deliveryDAO.update(delivery);
    }

    public void deleteDelivery(int id){
        deliveryDAO.delete(id);
    }

    public void addDelivery(Delivery delivery){
        deliveryDAO.add(delivery);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
