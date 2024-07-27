package com.piotto.apiproduct.services;

import com.piotto.apiproduct.domain.Client;
import com.piotto.apiproduct.domain.Order;
import com.piotto.apiproduct.repositories.OrderRepository;
import com.piotto.apiproduct.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findOne(Integer id) {
        Optional<Order> obj = orderRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Order.class.getName()
        ));
    }
}
