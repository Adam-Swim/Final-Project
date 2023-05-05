package com.watchdog.watchdog.service;

import java.util.List;
import java.util.Optional;
import com.watchdog.watchdog.entity.Order;

public interface WatchdogOrderService {
  Order createOrder(Order order);
  Optional<Order> getOrderById(Long id);
  List<Order> getAllOrders();
  Order updateOrder(Order order);
  void deleteOrder(Long id);

}
