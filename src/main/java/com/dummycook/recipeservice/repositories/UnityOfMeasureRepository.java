package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.UnityOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnityOfMeasureRepository extends JpaRepository<UnityOfMeasure, Long> {
    Optional<UnityOfMeasure> findByName(String name);

}