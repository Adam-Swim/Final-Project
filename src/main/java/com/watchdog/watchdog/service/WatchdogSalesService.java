package com.watchdog.watchdog.service;

import java.util.List;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;



public interface WatchdogSalesService {
  List<Watchdog> fetchWatchdogs(WatchdogModel model);

}
