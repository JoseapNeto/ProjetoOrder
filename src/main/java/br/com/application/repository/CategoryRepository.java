package br.com.application.repository;

import br.com.application.entity.CategoryEntity;
import br.com.application.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
