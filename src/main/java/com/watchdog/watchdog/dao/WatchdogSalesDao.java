package com.watchdog.watchdog.dao;

import java.util.List;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;

public interface WatchdogSalesDao {
  List<Watchdog> fetchWatchdogs(WatchdogModel model);

}
