package com.watchdog.watchdog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.watchdog.watchdog.entity.Accessory;

@Repository
public interface AccessoryRepository extends JpaRepository<Accessory, Long> {

}
