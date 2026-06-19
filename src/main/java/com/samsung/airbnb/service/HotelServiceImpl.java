package com.samsung.airbnb.service;

import com.samsung.airbnb.dto.HotelDto;
import com.samsung.airbnb.entity.Hotel;
import com.samsung.airbnb.entity.Room;
import com.samsung.airbnb.exception.ResourceNotFoundException;
import com.samsung.airbnb.repository.HotelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tools.jackson.databind.cfg.MapperBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{

    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name {}",hotelDto.getName());
        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel = hotelRepository.save(hotel);
        log.info("Created a new hotel with name {}",hotelDto.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {
        log.info("getting the hotel by id {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id"+id));

        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with id "+id));

        modelMapper.map(hotelDto, hotel);
        hotel = hotelRepository.save(hotel);
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        boolean exists = hotelRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Hotel not found with id "+id);

        Hotel hotel = hotelRepository
                .findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id "+id));
        hotelRepository.deleteById(id);

        for(Room room : hotel.getRooms()){
            inventoryService.deleteFutureInventories(room);
        }
    }

    @Override
    @Transactional
    public void activateHotel(Long id) {
        log.info("Activating the gtel with id: {}",id);
        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Hotel not found with id "+id));
        hotel.setActive(true);

        // assuming only do it once
        for(Room room : hotel.getRooms()){
            inventoryService.initializeRoomForAYear(room);
        }

    }
}
