package io.order.manager.food.order.manager.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long price;

/*    @ManyToOne
//    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
//    @JoinColumn(name = "categorie_id")
    private Category categorie;

    @ManyToOne
//    @JoinColumn(name = "food_order_id")
    private Food_Order food_order;

    @ManyToOne
//    @JoinColumn(name = "product_id")
    private Product productOffre;*/


    public Product() {
    }

/*    public Product getProductOffre() {
        return productOffre;
    }*/

/*
    public void setProductOffre(Product productOffre) {
        this.productOffre = productOffre;
    }
*/

    public Product(Long id, String name, String description, Long price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }


/*    public Product getProduct() {
        return product;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

/*    public Category getCategorie() {
        return categorie;
    }

    public void setCategorie(Category categorie) {
        this.categorie = categorie;
    }

    public Food_Order getFood_order() {
        return food_order;
    }

    public void setFood_order(Food_Order food_order) {
        this.food_order = food_order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }*/
}
