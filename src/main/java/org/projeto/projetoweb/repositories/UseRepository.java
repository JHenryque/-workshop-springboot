package org.projeto.projetoweb.repositories;

import org.projeto.projetoweb.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UseRepository extends JpaRepository<User, Long> {
}
