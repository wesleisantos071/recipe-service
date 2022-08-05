package com.dummycook.recipeservice.entities;

import javax.persistence.*;

@Table(name = "unity_of_measure")
@Entity
public class UnityOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_of_unity_id", nullable = false)
    private TypeOfUnity typeOfUnity;

    public TypeOfUnity getTypeOfUnity() {
        return typeOfUnity;
    }

    public void setTypeOfUnity(TypeOfUnity typeOfUnity) {
        this.typeOfUnity = typeOfUnity;
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