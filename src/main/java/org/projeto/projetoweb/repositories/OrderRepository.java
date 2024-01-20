package org.projeto.projetoweb.repositories;

import org.projeto.projetoweb.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
