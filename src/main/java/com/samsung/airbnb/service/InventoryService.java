package com.samsung.airbnb.service;

import com.samsung.airbnb.entity.Room;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteFutureInventories(Room room);
}
