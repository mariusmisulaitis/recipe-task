package org.marius.recipetask.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.marius.recipetask.converters.IngredientConverter;
import org.marius.recipetask.dto.CreateIngredientRequest;
import org.marius.recipetask.dto.GetIngredientResponse;
import org.marius.recipetask.entities.Ingredient;
import org.marius.recipetask.exceptions.ValidationErrorResponse;
import org.marius.recipetask.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientService ingredientService;

    @GetMapping
    public ResponseEntity<List<GetIngredientResponse>> getAllIngredients() {
        List<Ingredient> ingredients = this.ingredientService.getAllIngredients();
        if (ingredients.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(IngredientConverter.convertIngredientsToGetIngredientResponses(ingredients));
    }

    @PostMapping
    public ResponseEntity<?> createIngredient(@Valid @RequestBody CreateIngredientRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(new ValidationErrorResponse(bindingResult.getFieldErrors()));
        }

        Ingredient ingredient = this.ingredientService.saveIngredient(IngredientConverter.convertCreateIngredientRequestToIngredient(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(IngredientConverter.convertIngredientToGetIngredientResponse(ingredient));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetIngredientResponse> getIngredientById(@PathVariable Long id){
        Ingredient ingredient = this.ingredientService.getIngredientById(id);
        if (ingredient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(IngredientConverter.convertIngredientToGetIngredientResponse(ingredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredientById(@PathVariable Long id){
        if (this.ingredientService.deleteIngredientById(id) > 0){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
