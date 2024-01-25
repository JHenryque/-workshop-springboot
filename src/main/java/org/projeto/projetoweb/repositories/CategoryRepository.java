package org.projeto.projetoweb.repositories;

import org.projeto.projetoweb.entities.Category;
import org.projeto.projetoweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
