package com.example.databaseassignment.Repo;

import com.example.databaseassignment.entity.Food_Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface FoodRepository extends JpaRepository<Food_Item, Long> {
    @Query("select a from Food_Item a where a.name = ?1")
    Food_Item fetchByName(String name);
}
