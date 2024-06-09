package org.marius.recipetask.repositories;

import jakarta.transaction.Transactional;
import org.marius.recipetask.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Transactional
    long removeById(long id);
}
