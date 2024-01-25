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

    public User insert(User obj) {
        return useRepository.save(obj);
    }

    public void delete(Long id) {
        useRepository.deleteById(id);
    }

    public User update(Long id,User obj) {
        User entity = useRepository.getReferenceById(id);
        updateData(entity, obj);
        return useRepository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
