package org.projeto.projetoweb.resource;

import org.projeto.projetoweb.entities.Order;
import org.projeto.projetoweb.entities.User;
import org.projeto.projetoweb.services.OrderService;
import org.projeto.projetoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrdeResource {

    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> lista = orderService.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order obj = orderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}