package com.watchdog.watchdog.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;
import com.watchdog.watchdog.repository.WatchdogRepository;

@Service
public class DefaultWatchdogSalesService implements WatchdogSalesService {
  
  @Autowired
  private WatchdogRepository watchdogRepository;
  
  
  @Override
  public List<Watchdog> fetchWatchdogs(WatchdogModel model) {
    if (model != null) {
      return watchdogRepository.findByWatchdogModel(model);
    } else {
      return watchdogRepository.findAll();
    }
    
  }

}
