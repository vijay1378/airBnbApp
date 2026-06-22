package com.samsung.airbnb.controller;

import com.samsung.airbnb.dto.HotelDto;
import com.samsung.airbnb.dto.HotelInfoDto;
import com.samsung.airbnb.dto.HotelSearchRequest;
import com.samsung.airbnb.service.HotelService;
import com.samsung.airbnb.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowseController {

    private final InventoryService inventoryService;
    private final HotelService hotelService;

    @GetMapping("/search")
    public ResponseEntity<Page<HotelDto>>  searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest){
        Page<HotelDto> page = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId ){
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));
    }


}
