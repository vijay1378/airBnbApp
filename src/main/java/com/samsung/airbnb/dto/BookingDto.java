package com.samsung.airbnb.dto;

import com.samsung.airbnb.entity.Guest;
import com.samsung.airbnb.entity.Hotel;
import com.samsung.airbnb.entity.Room;
import com.samsung.airbnb.entity.User;
import com.samsung.airbnb.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookingDto {

    private Long id;
    private Integer roomsCount;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private BookingStatus bookingStatus;
    private Set<GuestDto> guests;
}
