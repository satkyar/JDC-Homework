package com.example.databaseassignment.service;

import com.example.databaseassignment.Repo.AnimalRepository;
import com.example.databaseassignment.Repo.CategoryRepository;
import com.example.databaseassignment.entity.Animal;
import com.example.databaseassignment.entity.Category;
import com.example.databaseassignment.util.JPAUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalCategoryService {

    private CategoryRepository categoryRepository;
    private AnimalRepository animalRepository;

    public AnimalCategoryService(CategoryRepository categoryRepository, AnimalRepository animalRepository) {
        this.categoryRepository = categoryRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    public void insertCategoryWithAnimals(){
        Category category = new Category();
        category.setCategory_Type("Big");

        Animal animal1 = new Animal();
        animal1.setType("Elephant");
        animal1.setTotal_number(20);

        Animal animal2 = new Animal();
        animal2.setType("Giraffe");
        animal2.setTotal_number(5);

        Animal animal3 = new Animal();
        animal3.setType("Rhino");
        animal3.setTotal_number(12);

        category.addAnimal(animal1);
        category.addAnimal(animal2);
        category.addAnimal(animal3);

        categoryRepository.save(category);

    }
}
