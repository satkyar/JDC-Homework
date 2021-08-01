package com.example.databaseassignment.Repo;

import com.example.databaseassignment.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    @Query("select a from Animal a where a.type = ?1")
    Animal fetchByName(String name);
}
