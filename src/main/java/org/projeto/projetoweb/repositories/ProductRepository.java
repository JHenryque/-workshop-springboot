package org.projeto.projetoweb.repositories;

import org.projeto.projetoweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
