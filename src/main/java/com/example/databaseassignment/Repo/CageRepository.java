package com.example.databaseassignment.Repo;

import com.example.databaseassignment.entity.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CageRepository extends JpaRepository<Cage, Long> {
}
