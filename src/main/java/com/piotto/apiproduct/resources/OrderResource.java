package com.piotto.apiproduct.resources;

import com.piotto.apiproduct.domain.Order;
import com.piotto.apiproduct.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> getOne(@PathVariable Integer id) {
        Order obj = orderService.findOne(id);
        return ResponseEntity.ok().body(obj);
    }
}
