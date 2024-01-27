package org.projeto.projetoweb.services;

import jakarta.persistence.EntityNotFoundException;
import org.projeto.projetoweb.entities.User;
import org.projeto.projetoweb.repositories.UseRepository;
import org.projeto.projetoweb.services.exceptions.DatabaseException;
import org.projeto.projetoweb.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User obj) {
        return useRepository.save(obj);
    }

    public void delete(Long id) {
        try {
            useRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id,User obj) {
        try {
            User entity = useRepository.getReferenceById(id);
            updateData(entity, obj);
            return useRepository.save(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
