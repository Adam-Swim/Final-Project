package com.watchdog.watchdog.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;
import com.watchdog.watchdog.service.WatchdogSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/watchdog-sales")
@Slf4j
public class DefaultWatchdogSalesController implements WatchdogSalesController {
  
  @Autowired
  private WatchdogSalesService watchdogSalesService;
  
  public DefaultWatchdogSalesController(WatchdogSalesService watchdogSalesService) {
    this.watchdogSalesService = watchdogSalesService;
  }
  
  @Override
  public List<Watchdog> fetchWatchdogs(WatchdogModel model, String description) {
    log.debug("model={}", model);
    return watchdogSalesService.fetchWatchdogs(model);
    
  }

}
