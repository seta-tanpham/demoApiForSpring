package com.example.demoapiforspring.service;

import com.example.demoapiforspring.entity.Order;
import com.example.demoapiforspring.entity.Product;
import com.example.demoapiforspring.entity.User;
import com.example.demoapiforspring.repository.OrderRepository;
import com.example.demoapiforspring.repository.ProductRepository;
import com.example.demoapiforspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order createOrder(Long userId, Long productId, Integer quantity) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        double totalPrice = product.getPrice() * quantity;

        if (user.getBalance() < totalPrice) {
            throw new RuntimeException("Insufficient balance");
        }

        user.setBalance(user.getBalance() - totalPrice);
        userRepository.save(user);

        Order order = new Order();
        order.setUser(user);
        order.setProduct(product);
        order.setQuantity(quantity);

        return orderRepository.save(order);
    }
}
