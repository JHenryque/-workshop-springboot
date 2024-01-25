package org.projeto.projetoweb.repositories;

import org.projeto.projetoweb.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
