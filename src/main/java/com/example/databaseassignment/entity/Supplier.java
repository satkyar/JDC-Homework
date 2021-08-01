package com.example.databaseassignment.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplier_Id;
    private String supplier_Name;
    private String contact_No;
    private String address;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "supplier")
    public List<Food_Item> food_items = new ArrayList<>();

    public void addFood_Item(Food_Item food_item){
        this.food_items.add(food_item);
        food_item.setSupplier(this);
    }

    public void removeFood_Item(Food_Item food_item){
        food_item.setSupplier(null);
        this.food_items.remove(food_item);
    }

    public void removeFood_Items(){
        Iterator<Food_Item> itr = this.food_items.iterator();
        while (itr.hasNext()){
            Food_Item food_item = itr.next();
            food_item.setSupplier(null);
            itr.remove();
        }
    }

    public List<Food_Item> getFood_items() {
        return food_items;
    }

    public void setFood_items(List<Food_Item> food_items) {
        this.food_items = food_items;
    }

    public Long getSupplier_Id() {
        return supplier_Id;
    }

    public void setSupplier_Id(Long supplier_Id) {
        this.supplier_Id = supplier_Id;
    }

    public String getSupplier_Name() {
        return supplier_Name;
    }

    public void setSupplier_Name(String supplier_Name) {
        this.supplier_Name = supplier_Name;
    }

    public String getContact_No() {
        return contact_No;
    }

    public void setContact_No(String contact_No) {
        this.contact_No = contact_No;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplier_Id=" + supplier_Id +
                ", supplier_Name='" + supplier_Name + '\'' +
                ", contact_No='" + contact_No + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
