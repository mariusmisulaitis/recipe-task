package org.marius.recipetask.converters;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.marius.recipetask.dto.CreateRecipeRequest;
import org.marius.recipetask.dto.GetRecipeResponse;
import org.marius.recipetask.entities.Recipe;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor(access= AccessLevel.PRIVATE)
public final class RecipeConverter {

    public static Recipe convertCreateRecipeRequestToRecipe(CreateRecipeRequest createRecipeRequest) {
        log.trace("convert request to recipe: {}", createRecipeRequest);
        Recipe recipe = null;
        if (createRecipeRequest != null) {
            recipe = new Recipe();
            recipe.setName(createRecipeRequest.getName());
            recipe.setCookingTime(createRecipeRequest.getCookingTime());
            recipe.setServings(createRecipeRequest.getServings());
            recipe.setInstructions(createRecipeRequest.getInstructions());
        }
        log.trace("converted recipe: {}", recipe);
        return recipe;
    }

    public static GetRecipeResponse convertRecipeToGetRecipeResponse(Recipe recipe) {
        GetRecipeResponse response = null;
        if (recipe != null) {
            response = new GetRecipeResponse();
            response.setId(recipe.getId());
            response.setName(recipe.getName());
            response.setCookingTime(recipe.getCookingTime());
            response.setServings(recipe.getServings());
            response.setInstructions(recipe.getInstructions());
            response.setIngredients(IngredientConverter.convertIngredientsToGetIngredientResponses(recipe.getIngredients()));
        }
        return response;
    }

    public static List<GetRecipeResponse> convertRecipeListToGetRecipeResponseList(List<Recipe> recipes) {
        List<GetRecipeResponse> responses = new ArrayList<>();
        for (Recipe recipe : recipes) {
            responses.add(convertRecipeToGetRecipeResponse(recipe));
        }
        return responses;
    }
}
