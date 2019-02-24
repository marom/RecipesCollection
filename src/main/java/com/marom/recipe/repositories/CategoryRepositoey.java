package com.marom.recipe.repositories;

import com.marom.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepositoey extends CrudRepository<Category, Long> {
}
