package com.watchdog.watchdog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.OrderRequest;

@Validated
@RequestMapping("/orders")
public interface WatchdogOrderController {
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Order createOrder(@RequestBody OrderRequest orderRequest);

}
