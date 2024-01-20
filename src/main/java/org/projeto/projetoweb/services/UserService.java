package org.projeto.projetoweb.services;

import org.projeto.projetoweb.entities.User;
import org.projeto.projetoweb.repositories.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@EnableJpaRepositories(basePackages = "org.projeto.projetoweb.services")

@Service
public class UserService {

    @Autowired
    private UseRepository useRepository;

    public List<User> findAll() {
        return useRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = useRepository.findById(id);
        return obj.get();
    }
}
