package io.order.manager.food.order.manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;

/*    @OneToMany(mappedBy = "event")
    private List<Offre> offreEventList = new ArrayList<>();*/

    public Event() {
    }

    public Event(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*public List<Offre> getOffreEventList() {
        return offreEventList;
    }

    public void setOffreEventList(List<Offre> offreEventList) {
        this.offreEventList = offreEventList;
    }
*/
}
