package com.samsung.airbnb.service;

import com.samsung.airbnb.dto.BookingDto;
import com.samsung.airbnb.dto.BookingRequest;
import com.samsung.airbnb.dto.GuestDto;

import java.util.List;

public interface BookingService {
    BookingDto initialiseBooking(BookingRequest bookingRequest) ;

    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
