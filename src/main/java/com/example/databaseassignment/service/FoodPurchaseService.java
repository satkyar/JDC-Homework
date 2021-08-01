package com.example.databaseassignment.service;

import com.example.databaseassignment.Repo.SupplierRepository;
import com.example.databaseassignment.entity.Food_Item;
import com.example.databaseassignment.entity.Supplier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoodPurchaseService {

    private final SupplierRepository supplierRepository;

    public FoodPurchaseService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public void insertSupplierWithFoodItems(){
        Supplier supplier = new Supplier();
        supplier.setSupplier_Name("U Ba");
        supplier.setAddress("Mandalay");
        supplier.setContact_No("111-222-333");

        Food_Item food_item1 = new Food_Item();
        food_item1.setName("Banana");
        food_item1.setQuantity(10);

        Food_Item food_item2 = new Food_Item();
        food_item2.setName("Sugarcane");
        food_item2.setQuantity(10);

        Food_Item food_item3 = new Food_Item();
        food_item3.setName("Water Lily");
        food_item3.setQuantity(10);

        supplier.addFood_Item(food_item1);
        supplier.addFood_Item(food_item2);
        supplier.addFood_Item(food_item3);

        supplierRepository.save(supplier);
    }


}
