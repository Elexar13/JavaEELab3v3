package entities;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Delivery.findAll", query = "select d from Delivery d")
})
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name = "id")
    private int id;
    @Basic
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
