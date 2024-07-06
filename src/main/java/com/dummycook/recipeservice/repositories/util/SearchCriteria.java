package com.dummycook.recipeservice.repositories.util;

import lombok.Data;

@Data
public class SearchCriteria {
    private String key;
    private Operation operation;
    private Object value;
}
