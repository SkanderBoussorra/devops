package io.order.manager.food.order.manager.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Food_Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private long totalPrice;
    private int quantity;

/*    @OneToMany(mappedBy = "product")
    private List<Product> products = new ArrayList<>();

    @ManyToOne
//    @JoinColumn(name = "category_id")
    private Category category;

    public Category getCategory() {
        return category;
    }*/


    public Food_Order() {
    }

    public Food_Order(String reference, long totalPrice, int quantity, List<Product> products, Category category) {
        this.reference = reference;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
       /* this.products = products;
        this.category = category;*/
    }

    public Food_Order(int id, String reference, long totalPrice, int quantity) {
        this.id = id;
        this.reference = reference;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

/*    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCategory(Category category) {
        this.category = category;
    }*/

    @Override
    public String toString() {
        return "Food_Order{" +
                "id=" + id +
                ", reference='" + reference + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }
}
