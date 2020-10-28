package beans;


import dao.EditionDAO;
import dao.OrderDAO;
import entities.Edition;
import entities.Order;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

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

    public void deleteOrder(int id){
        orderDAO.delete(id);
    }

}
