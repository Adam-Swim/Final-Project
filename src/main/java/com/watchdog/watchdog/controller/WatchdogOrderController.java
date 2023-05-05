package com.watchdog.watchdog.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.OrderRequest;
import com.watchdog.watchdog.entity.Watchdog;

@Validated
@RequestMapping("/orders")
public interface WatchdogOrderController {
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Order createOrder(@RequestBody OrderRequest orderRequest);
  
  @GetMapping("/watchdogs")
  List<Watchdog> getWatchdogs();
  
  @PutMapping("/{id}")
  ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId, @Valid Order orderDetails);
  
  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long orderId);

}
