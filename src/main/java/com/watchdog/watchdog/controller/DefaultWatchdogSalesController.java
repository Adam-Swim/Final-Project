package com.watchdog.watchdog.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;
import com.watchdog.watchdog.errorhandler.ResourceNotFoundException;
import com.watchdog.watchdog.repository.OrderRepository;
import com.watchdog.watchdog.service.WatchdogSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/watchdog-sales")
@Slf4j
public class DefaultWatchdogSalesController implements WatchdogSalesController {
  
  @Autowired
  private WatchdogSalesService watchdogSalesService;
  
  @Autowired
  private OrderRepository orderRepository;
  
  public DefaultWatchdogSalesController(WatchdogSalesService watchdogSalesService) {
    this.watchdogSalesService = watchdogSalesService;
  }
  
  @Override
  public List<Watchdog> fetchWatchdogs(WatchdogModel model) {
    log.debug("model={}", model);
    return watchdogSalesService.fetchWatchdogs(model); 
  }

  @Override
  public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId, @Valid @RequestBody Order orderDetails) {
    Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));
    
    
    order.setCustomer(orderDetails.getCustomer());
    order.setWatchdog(orderDetails.getWatchdog());
    order.setTotalPrice(orderDetails.getTotalPrice());
    
    final Order updatedOrder = orderRepository.save(order);
    return ResponseEntity.ok(updatedOrder);
  }

}
