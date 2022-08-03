package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.UnityOfMeasure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnityOfMeasureRepository extends JpaRepository<UnityOfMeasure, Long> {
}