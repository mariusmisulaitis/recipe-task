package org.marius.recipetask.repositories;

import jakarta.transaction.Transactional;
import org.marius.recipetask.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Transactional
    long removeById(long id);
}
