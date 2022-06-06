package io.order.manager.food.order.manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Offre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private long remise;


/*    @OneToMany(mappedBy = "productOffre")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name = "event_id")
    private Event event;

    public Event getEvent() {
        return event;
    }*/

    public Offre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getRemise() {
        return remise;
    }

    public void setRemise(long remise) {
        this.remise = remise;
    }

/*    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setEvent(Event event) {
        this.event = event;
    }*/
}
