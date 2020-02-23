package ru.mobydrake.entites;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person_tbl")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    private String name;

    @ManyToMany
    @JoinTable(
            name = "product_buyer", // название таблицы
            joinColumns = @JoinColumn(name = "person_id"),  // то что связываем
            inverseJoinColumns = @JoinColumn(name = "product_id") // то на что связываем
    )
    private List<Product> products;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
