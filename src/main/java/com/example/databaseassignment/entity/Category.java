package com.example.databaseassignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Category implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_Id;
    private String category_Type;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    public List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal){
        this.animals.add(animal);
        animal.setCategory(this);
    }

    public void removeAnimal(Animal animal){
        animal.setCategory(null);
        this.animals.remove(animal);
    }

    public void removeAnimals(){
        Iterator<Animal> itr = this.animals.iterator();
        while (itr.hasNext()){
            Animal animal = itr.next();
            animal.setCategory(null);
            itr.remove();
        }
    }

    public String getCategory_Type() {
        return category_Type;
    }

    public void setCategory_Type(String category_Type) {
        this.category_Type = category_Type;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_Type='" + category_Type + '\'' +
                '}';
    }
}
