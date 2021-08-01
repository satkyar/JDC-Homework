package com.example.databaseassignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Food_Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long food_Id;
    private String name;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "supplier_Id")
    private Supplier supplier = new Supplier();

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "animal_food",
        joinColumns = @JoinColumn(name = "food_Id"),
        inverseJoinColumns = @JoinColumn(name = "animal_Id")
    )
    public List<Animal> animals = new ArrayList<>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void addAnimal(Animal animal){
        this.getAnimals().add(animal);
        animal.getFood_items().add(this);
    }

    public void removeAnimal(Animal animal){
        animal.getFood_items().add(null);
        this.getAnimals().remove(animal);
    }

    public void removeAnimals(){
        Iterator<Animal> itr = this.animals.iterator();
        while (itr.hasNext()){
            Animal animal = itr.next();
            animal.getFood_items().add(null);
            itr.remove();
        }
    }

    public Long getFood_Id() {
        return food_Id;
    }

    public void setFood_Id(Long food_Id) {
        this.food_Id = food_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "Food_Item{" +
                "food_Id=" + food_Id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
