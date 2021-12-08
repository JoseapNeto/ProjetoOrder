package br.com.application.repository;

import br.com.application.entity.OrderEntity;
import br.com.application.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
