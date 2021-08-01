package com.example.databaseassignment.service;

import com.example.databaseassignment.Repo.AnimalRepository;
import com.example.databaseassignment.Repo.CageRepository;
import com.example.databaseassignment.entity.Animal;
import com.example.databaseassignment.entity.Cage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CageRegistrationService {

    private final CageRepository cageRepository;
    private final AnimalRepository animalRepository;

    public CageRegistrationService(CageRepository cageRepository, AnimalRepository animalRepository) {
        this.cageRepository = cageRepository;
        this.animalRepository = animalRepository;
    }

    @Transactional
    public void insertCageWithAnimal(){
        Cage cage1 = new Cage();
        cage1.setCage_no("1");
        cage1.setLocation("Zone 1");
        Cage cage2 = new Cage();
        cage2.setCage_no("2");
        cage2.setLocation("Zone 1");
        Cage cage3 = new Cage();
        cage3.setCage_no("1");
        cage3.setLocation("Zone 2");

        Animal animal1 = animalRepository.fetchByName("Elephant");
        Animal animal2 = animalRepository.fetchByName("Giraffe");
        Animal animal3 = animalRepository.fetchByName("Rhino");

        cage1.setAnimal(animal1);
        cage2.setAnimal(animal2);
        cage3.setAnimal(animal3);

        cageRepository.save(cage1);
        cageRepository.save(cage2);
        cageRepository.save(cage3);

    }
}
