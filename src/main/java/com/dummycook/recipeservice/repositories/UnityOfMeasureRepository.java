package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.UnityOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UnityOfMeasureRepository extends JpaRepository<UnityOfMeasure, Long> {
    @Query("select u from UnityOfMeasure u where lower(u.name) = lower(?1)")
    Optional<UnityOfMeasure> findByName(String name);

}