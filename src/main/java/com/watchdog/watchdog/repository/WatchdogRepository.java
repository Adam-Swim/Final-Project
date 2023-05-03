package com.watchdog.watchdog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.watchdog.watchdog.entity.Watchdog;

@Repository
public interface WatchdogRepository extends JpaRepository<Watchdog, Long> {

}
