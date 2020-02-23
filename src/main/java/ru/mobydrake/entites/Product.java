package ru.mobydrake.entites;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double cost;

    public Product() {
    }

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @ManyToMany
    @JoinTable(
            name = "product_buyer", // название таблицы
            joinColumns = @JoinColumn(name = "product_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "person_id") // то на что связываем
    )
    private List<Product> buyers;


    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title='" + title + '\'' + ", cost=" + cost + '}';
    }
}
