package br.com.application.repository;

import br.com.application.entity.ProductEntity;
import br.com.application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
}
