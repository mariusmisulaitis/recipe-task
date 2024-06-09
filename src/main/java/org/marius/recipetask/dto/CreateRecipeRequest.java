package org.marius.recipetask.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Data
public class CreateRecipeRequest {
    @NotBlank(message = "{validation.constraints.not.empty.message}")
    @Size(min = 1, max = 100, message = "{validation.constraints.size.message}")
    private final String name;
    @NotNull(message = "{validation.constraints.not.empty.message}")
    @Positive(message = "{validation.constraints.positive.message}")
    @Max(value = 50, message = "{validation.constraints.max.message}")
    private final int servings;
    @NotNull(message = "{validation.constraints.not.empty.message}")
    @Positive(message = "{validation.constraints.positive.message}")
    @Max(value = 1440, message = "{validation.constraints.max.message}")
    private final int cookingTime;
    @NotBlank(message = "{validation.constraints.not.empty.message}")
    @Size(min = 1, max = 255, message = "{validation.constraints.size.message}")
    private final String instructions;
    @NotEmpty(message = "{validation.constraints.not.empty.message}")
    @Size(min = 1, max = 50, message = "{validation.constraints.size.message}")
    private final List<Long> ingredientIds;
}
