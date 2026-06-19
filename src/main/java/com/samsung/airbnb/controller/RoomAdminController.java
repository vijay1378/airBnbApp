package com.samsung.airbnb.controller;

import com.samsung.airbnb.dto.RoomDto;
import com.samsung.airbnb.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/hotels/{hotelId}/rooms")
@RequiredArgsConstructor
public class RoomAdminController {
    private final RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId,
                                                 @RequestBody RoomDto roomDto){
        RoomDto roomDto1 = roomService.createNewRoom(hotelId,roomDto);
        return new ResponseEntity<>(roomDto1,HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<RoomDto>> getAllRoomsInHotel(@PathVariable Long hotelId){
        List<RoomDto> dtoList = roomService.getAllRoomsInHotel(hotelId);
        return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/{roomId}")
    ResponseEntity<RoomDto> getRoomById(@PathVariable Long roomId){
        RoomDto roomDto = roomService.getRoomById(roomId);
        return  ResponseEntity.ok(roomDto);
    }

    @DeleteMapping("/{roomId}")
    ResponseEntity<Void> deleteRoomById(@PathVariable Long roomId){
        roomService.deleteRoomById(roomId);
        return ResponseEntity.noContent().build();
    }
}
