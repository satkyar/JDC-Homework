package com.example.databaseassignment.Repo;

import com.example.databaseassignment.entity.Category;
import com.example.databaseassignment.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select a from Category a join fetch a.animals where a.category_Type = ?1")
    Category fetchByName(String name);
}
