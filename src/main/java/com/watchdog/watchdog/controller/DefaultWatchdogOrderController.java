package com.watchdog.watchdog.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.OrderRequest;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.errorhandler.ResourceNotFoundException;
import com.watchdog.watchdog.repository.OrderRepository;
import com.watchdog.watchdog.repository.WatchdogRepository;




@RestController
@RequestMapping("/watchdogs")
public class DefaultWatchdogOrderController implements WatchdogOrderController {
  
  private final WatchdogRepository watchdogRepository;
  
  @Autowired
  private OrderRepository orderRepository;
  
  public DefaultWatchdogOrderController(WatchdogRepository watchdogRepository) {
    this.watchdogRepository = watchdogRepository;
  }

  @Override
  public Order createOrder(OrderRequest orderRequest) {
    return null;
  }
  
  @Override
  @GetMapping
  public List<Watchdog> getWatchdogs() {
    return watchdogRepository.findAll();
  }
  
  @Override
  @PutMapping("/orders/{id}")
  public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId, @Valid @RequestBody Order orderDetails){
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
    
    order.setCustomer(orderDetails.getCustomer());
    order.setWatchdog(orderDetails.getWatchdog());
    order.setTotalPrice(orderDetails.getTotalPrice());
    
    final Order updatedOrder = orderRepository.save(order);
    return ResponseEntity.ok(updatedOrder);
    
  }
  
  @Override
  @DeleteMapping("/orders/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long orderId) {
    Order order = orderRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
    
    orderRepository.delete(order);
    return ResponseEntity.noContent().build();
  }

}
