package com.example.databaseassignment.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cage_Id;
    private String cage_no;
    private String location;

    @OneToOne(mappedBy = "cage", cascade = CascadeType.ALL, orphanRemoval = true)
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
        animal.setCage(this);
    }

    public String getCage_no() {
        return cage_no;
    }

    public void setCage_no(String cage_no) {
        this.cage_no = cage_no;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Cage{" +
                "cage_no='" + cage_no + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
