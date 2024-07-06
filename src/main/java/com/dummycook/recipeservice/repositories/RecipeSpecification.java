package com.dummycook.recipeservice.repositories;

import com.dummycook.recipeservice.entities.Recipe;
import com.dummycook.recipeservice.repositories.util.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class RecipeSpecification implements Specification<Recipe> {

    private SearchCriteria searchCriteria;


    @Override
    public Predicate toPredicate(Root<Recipe> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Expression expressionKey = root.get(searchCriteria.getKey());
        Object value = searchCriteria.getValue();
        switch (searchCriteria.getOperation()) {
            case EQ:
                return builder.equal(expressionKey, value);
            case LIKE:
                return builder.like(expressionKey, "%" + value + "%");
            case GT:
                return builder.greaterThan(expressionKey, (String) value);
            case GTE:
                return builder.greaterThanOrEqualTo(expressionKey, (String) value);
            case LT:
                return builder.lessThan(expressionKey, (String) value);
            case LTE:
                return builder.lessThanOrEqualTo(expressionKey, (String) value);
        }
        return null;
    }
}
