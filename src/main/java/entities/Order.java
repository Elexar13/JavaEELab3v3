package entities;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
class OrderId implements Serializable{
    private int editionId;
    private int recipientId;
    private int deliveryId;
}

@Entity
public class Order implements Serializable {
    @EmbeddedId
    private OrderId id;
    private String status;

}
