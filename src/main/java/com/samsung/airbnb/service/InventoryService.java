package com.samsung.airbnb.service;

import com.samsung.airbnb.dto.HotelDto;
import com.samsung.airbnb.dto.HotelPriceDto;
import com.samsung.airbnb.dto.HotelSearchRequest;
import com.samsung.airbnb.entity.Room;
import org.springframework.data.domain.Page;

public interface InventoryService {

    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelPriceDto> searchHotels(HotelSearchRequest hotelSearchRequest);
}
