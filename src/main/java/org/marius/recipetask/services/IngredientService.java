package org.marius.recipetask.services;


import lombok.RequiredArgsConstructor;
import org.marius.recipetask.entities.Ingredient;
import org.marius.recipetask.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getIngredientByIds(List<Long> ingredientIds) {
        return ingredientRepository.findAllById(ingredientIds);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    public long deleteIngredientById(Long id) {
        return ingredientRepository.removeById(id);
    }

    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.saveAndFlush(ingredient);
    }
}
