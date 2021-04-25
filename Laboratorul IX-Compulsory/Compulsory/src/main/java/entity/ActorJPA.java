package entity;

import javax.persistence.*;
import java.io.Serializable;

@NamedQuery(name = "findByNameQuery", query = "SELECT a FROM ActorJPA a WHERE a.name = :nume")
@Entity
@Table(name = "ACTORS")
public class ActorJPA implements Serializable {

    public ActorJPA() {
    }

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "artistSequence", sequenceName = "artistSequence", allocationSize = 1)
    @GeneratedValue(generator = "artistSequence", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "NAME")
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


}
