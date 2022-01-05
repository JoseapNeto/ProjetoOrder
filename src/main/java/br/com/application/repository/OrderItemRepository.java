package br.com.application.repository;

import br.com.application.entity.OrderEntity;
import br.com.application.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Integer> {
}
