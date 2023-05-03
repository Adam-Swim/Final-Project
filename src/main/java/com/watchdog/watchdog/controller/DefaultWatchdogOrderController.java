package com.watchdog.watchdog.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.OrderRequest;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.repository.WatchdogRepository;


@RestController
@RequestMapping("/watchdogs")
public class DefaultWatchdogOrderController implements WatchdogOrderController {
  
  private final WatchdogRepository watchdogRepository;
  
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
  

}
