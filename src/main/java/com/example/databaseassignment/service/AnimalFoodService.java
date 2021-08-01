package com.example.databaseassignment.service;

import com.example.databaseassignment.Repo.AnimalRepository;
import com.example.databaseassignment.Repo.FoodRepository;
import com.example.databaseassignment.entity.Animal;
import com.example.databaseassignment.entity.Food_Item;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalFoodService {

    private FoodRepository foodRepository;
    private AnimalRepository animalRepository;

    public AnimalFoodService(FoodRepository foodRepository, AnimalRepository animalRepository) {
        this.foodRepository = foodRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    public void insertAnimalWithFood(){
        Food_Item food_item1 = foodRepository.fetchByName("Banana");
        Food_Item food_item2 = foodRepository.fetchByName("Sugarcane");
        Food_Item food_item3 = foodRepository.fetchByName("Water Lily");

        Animal animal1 = animalRepository.fetchByName("Elephant");
        Animal animal2 = animalRepository.fetchByName("Giraffe");
        Animal animal3 = animalRepository.fetchByName("Rhino");

        food_item1.addAnimal(animal1);
        food_item2.addAnimal(animal1);
        food_item3.addAnimal(animal2);
        food_item3.addAnimal(animal3);

        foodRepository.save(food_item1);
        foodRepository.save(food_item2);
        foodRepository.save(food_item3);

    }
}
