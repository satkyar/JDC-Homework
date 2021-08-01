package com.example.databaseassignment.Repo;

import com.example.databaseassignment.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    @Query("select a from Supplier a join fetch a.food_items where a.supplier_Name = ?1")
    Supplier fetchByName(String name);
}
