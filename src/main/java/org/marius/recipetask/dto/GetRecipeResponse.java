package org.marius.recipetask.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetRecipeResponse {
    private Long id;
    private String name;
    private int servings;
    private int cookingTime;
    private String instructions;
    private List<GetIngredientResponse> ingredients;
}
