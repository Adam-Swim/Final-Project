package com.watchdog.watchdog.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.repository.OrderRepository;

public class DefaultWatchdogOrderService implements WatchdogOrderService {
  
  @Autowired
  private OrderRepository orderRepository;
  
  @Override
  public Order createOrder(Order order) {
    return orderRepository.save(order);
  }

  @Override 
  public Optional<Order> getOrderById(Long id) {
    return orderRepository.findById(id);
  }
  
  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }
  
  @Override
  public Order updateOrder(Order order) {
    return orderRepository.save(order);
  }
  
  @Override
  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }
  
  
}
