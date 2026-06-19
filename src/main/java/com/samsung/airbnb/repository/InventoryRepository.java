package com.samsung.airbnb.repository;

import com.samsung.airbnb.entity.Inventory;
import com.samsung.airbnb.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    void deleteByDateAfterAndRoom(LocalDate today, Room room);
}
