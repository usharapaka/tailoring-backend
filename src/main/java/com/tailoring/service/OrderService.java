package com.tailoring.service;

import com.tailoring.entity.Customer;
import com.tailoring.entity.Order;
import com.tailoring.entity.Tailor;
import com.tailoring.repository.CustomerRepository;
import com.tailoring.repository.OrderRepository;
import com.tailoring.repository.TailorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final TailorRepository tailorRepository;

    public OrderService(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            TailorRepository tailorRepository) {

        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.tailorRepository = tailorRepository;
    }

    public Order saveOrder(Order order) {

        Customer customer = customerRepository.findById(
                order.getCustomer().getId()
        ).orElseThrow(() ->
                new RuntimeException("Customer not found"));

        Tailor tailor = tailorRepository.findById(
                order.getTailor().getId()
        ).orElseThrow(() ->
                new RuntimeException("Tailor not found"));

        order.setCustomer(customer);
        order.setTailor(tailor);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

   public Order updateOrder(Long id, Order order) {

    Order existingOrder = orderRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Order not found"));

    // Customer update
    if (order.getCustomer() != null &&
            order.getCustomer().getId() != null) {

        Customer customer = customerRepository.findById(
                order.getCustomer().getId()
        ).orElseThrow(() ->
                new RuntimeException("Customer not found"));

        existingOrder.setCustomer(customer);
    }

    // Tailor update only if provided
    if (order.getTailor() != null &&
            order.getTailor().getId() != null) {

        Tailor tailor = tailorRepository.findById(
                order.getTailor().getId()
        ).orElseThrow(() ->
                new RuntimeException("Tailor not found"));

        existingOrder.setTailor(tailor);
    }

    existingOrder.setDressType(order.getDressType());
    existingOrder.setStatus(order.getStatus());
    existingOrder.setPrice(order.getPrice());

    return orderRepository.save(existingOrder);
}
    public void deleteOrder(Long id) {

    Order order = orderRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Order not found"));

    order.setHiddenFromTailor(true);

    orderRepository.save(order);
}

public Order rejectOrder(Long id) {

    Order order = orderRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Order not found"));

    order.setStatus("Rejected");

    return orderRepository.save(order);
}

}