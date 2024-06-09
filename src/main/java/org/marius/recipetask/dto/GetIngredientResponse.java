package org.marius.recipetask.dto;

import lombok.Data;

@Data
public class GetIngredientResponse {
    private Long id;
    private String name;
    private String category;
}
