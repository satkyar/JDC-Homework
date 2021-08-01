package com.example.databaseassignment;

import com.example.databaseassignment.service.AnimalCategoryService;
import com.example.databaseassignment.service.AnimalFoodService;
import com.example.databaseassignment.service.CageRegistrationService;
import com.example.databaseassignment.service.FoodPurchaseService;

import com.example.databaseassignment.util.JPAUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DatabaseAssignmentApplication implements CommandLineRunner {

    private final FoodPurchaseService foodPurchaseService;
    private final AnimalCategoryService animalCategoryService;
    private final CageRegistrationService cageRegistrationService;
    private final AnimalFoodService animalFoodService;

    public DatabaseAssignmentApplication(
            FoodPurchaseService foodPurchaseService,
            AnimalCategoryService animalCategoryService,
            CageRegistrationService cageRegistrationService,
            AnimalFoodService animalFoodService) {
        this.foodPurchaseService = foodPurchaseService;
        this.animalCategoryService = animalCategoryService;
        this.cageRegistrationService = cageRegistrationService;
        this.animalFoodService = animalFoodService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseAssignmentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n Inserting Supplier with Food Items");
        foodPurchaseService.insertSupplierWithFoodItems();

        System.out.println("\n ----------------------------------");

        System.out.println("\n Inserting Category with Animals");
        animalCategoryService.insertCategoryWithAnimals();

        System.out.println("\n ----------------------------------");

        System.out.println("\n Inserting Cage with Animal");
        cageRegistrationService.insertCageWithAnimal();

        System.out.println("\n ----------------------------------");

        System.out.println("\n Updating Animal with Food");
        animalFoodService.insertAnimalWithFood();

        System.out.println("\n ----------------------------------");
        JPAUtil.checkData("select * from supplier");
        JPAUtil.checkData("select * from food_item");
        JPAUtil.checkData("select * from category");
        JPAUtil.checkData("select * from cage");
        JPAUtil.checkData("select * from animal");
        JPAUtil.checkData("select * from animal_food");

    }
}
