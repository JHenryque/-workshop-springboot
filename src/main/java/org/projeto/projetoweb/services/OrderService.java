package org.projeto.projetoweb.services;

import org.projeto.projetoweb.entities.Order;
import org.projeto.projetoweb.entities.User;
import org.projeto.projetoweb.repositories.OrderRepository;
import org.projeto.projetoweb.repositories.UseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@EnableJpaRepositories(basePackages = "org.projeto.projetoweb.services")

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.get();
    }
}
