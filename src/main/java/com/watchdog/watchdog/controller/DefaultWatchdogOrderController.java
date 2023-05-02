package com.watchdog.watchdog.controller;

import org.springframework.web.bind.annotation.RestController;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.OrderRequest;


@RestController
public class DefaultWatchdogOrderController implements WatchdogOrderController {

  @Override
  public Order createOrder(OrderRequest orderRequest) {
    // TODO Auto-generated method stub
    return null;
  }

}
