package com.watchdog.watchdog.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.watchdog.watchdog.entity.Watchdog;
import com.watchdog.watchdog.entity.WatchdogModel;

@Repository
public interface WatchdogRepository extends JpaRepository<Watchdog, Long> {
  List<Watchdog> findByWatchdogModel(WatchdogModel model);

}
