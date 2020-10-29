package beans;


import dao.EditionDAO;
import dao.OrderDAO;
import entities.Delivery;
import entities.Edition;
import entities.Order;
import entities.Status;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SessionScoped
@Named
public class OrderBean implements Serializable {

    @EJB
    private OrderDAO orderDAO;

    private Order order = new Order();

    public Order getOrder() {
        return order;
    }

    public List<Order> getOrders(){
        return orderDAO.findAll();
    }

    public List<Integer> getEditionId(){
        return orderDAO.selectEditionId();
    }
    public List<Integer> getRecipientId(){
        return orderDAO.selectRecipientId();
    }

    public List<Integer> getDeliveryId(){
        return orderDAO.selectDeliveryId();
    }
    public List<String> getStatuses(){
        return Arrays.stream(Status.values()).map(Enum::name).collect(Collectors.toList());
    }

    public void deleteOrder(int id){
        orderDAO.delete(id);
    }

    public void addOrder(Order order){
        orderDAO.add(new Order(order));
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
