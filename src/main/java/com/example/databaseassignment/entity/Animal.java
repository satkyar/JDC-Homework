package com.example.databaseassignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long animal_Id;
    private String type;
    private int total_number;

    @OneToOne @JoinColumn(name = "cage_Id")
    private Cage cage;

    public Cage getCage() {
        return cage;
    }

    public void setCage(Cage cage) {
        this.cage = cage;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) @JoinColumn(name = "category_Id")
    public Category category = new Category();

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToMany(mappedBy = "animals")
    public List<Food_Item> food_items = new ArrayList<>();

    public List<Food_Item> getFood_items() {
        return food_items;
    }

    public void setFood_items(List<Food_Item> food_items) {
        this.food_items = food_items;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", total_number=" + total_number +
                '}';
    }
}
