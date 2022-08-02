package com.dummycook.recipeservice.entities;

import javax.persistence.*;

@Table(name = "ingredient")
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "is_meat")
    private Boolean isMeat;

    @Column(name = "is_animal_originated")
    private Boolean isAnimalOriginated;

    public Boolean getIsAnimalOriginated() {
        return isAnimalOriginated;
    }

    public void setIsAnimalOriginated(Boolean isAnimalOriginated) {
        this.isAnimalOriginated = isAnimalOriginated;
    }

    public Boolean getIsMeat() {
        return isMeat;
    }

    public void setIsMeat(Boolean isMeat) {
        this.isMeat = isMeat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}