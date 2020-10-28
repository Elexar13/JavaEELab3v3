package entities;

import validation.City;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "edition")
@SecondaryTable(name = "edition_city")
@NamedQueries({
        @NamedQuery(name = "Edition.findAll", query = "select e from Edition e")
})
@City
public class Edition {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @NotNull @Pattern(regexp = "^[a-zA-Z \\u0400-\\u04FF]+")
    @Size(max = 100, message = "Назва повинна містити до 100 символів")
    @Column(name = "name")
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
