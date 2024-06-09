package org.marius.recipetask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateIngredientRequest {
    @NotBlank(message = "{validation.constraints.not.empty.message}")
    @Size(min = 1, max = 100, message = "{validation.constraints.size.message}")
    private final String name;
    @NotBlank(message = "{validation.constraints.not.empty.message}")
    @Size(min = 1, max = 100, message = "{validation.constraints.size.message}")
    private final String category;
}
