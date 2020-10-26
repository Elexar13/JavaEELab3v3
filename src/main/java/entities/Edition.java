package entities;

import javax.persistence.*;

@Entity
@Table(name = "edition")
@SecondaryTable(name = "edition_city", pkJoinColumns = @PrimaryKeyJoinColumn(name = "edition_id"))
@NamedQueries({
        @NamedQuery(name = "Edition.findAll", query = "select e from Edition e")
})
public class Edition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column(name = "id")
    private int id;
    @Basic @Column(name = "name")
    private String name;
    @Basic @Column(name = "city", table = "edition_city")
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
