package entities;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select o from Order o")
})
public class Order implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    private Recipient recipient = new Recipient();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id")
    private Edition edition = new Edition();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery = new Delivery();
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order(){}

    public Order(Order order){
        this.recipient.setId(order.recipient.getId());
        this.edition.setId(order.edition.getId());
        this.delivery.setId(order.delivery.getId());
        this.status = order.status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Recipient getRecipient() {return recipient;}
    public void setRecipient(Recipient recipient) {
        this.recipient = new Recipient();
    }

    public Edition getEdition() {
        return edition;
    }
    public void setEdition(Edition edition) {
        this.edition = new Edition();
    }

    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = new Delivery();
    }

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
}
