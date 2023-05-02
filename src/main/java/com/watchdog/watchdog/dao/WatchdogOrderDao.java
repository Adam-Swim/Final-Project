package com.watchdog.watchdog.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import com.watchdog.watchdog.entity.Accessory;
import com.watchdog.watchdog.entity.Customers;
import com.watchdog.watchdog.entity.Order;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;

public interface WatchdogOrderDao {
  List<Accessory> FetchAccessories(List<String> accessoryIds);
  Optional<Customers> fetchCustomers(String customerId);
  Optional<Watchdog> fetchModel(String watchdogId, WatchdogModel model, int mastHeight, int panelWatts);
  
  Order saveOrder(Customers customers, Watchdog watchdog, List<Accessory> accessories, BigDecimal price);
  

}
