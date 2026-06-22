package com.samsung.airbnb.dto;

import com.samsung.airbnb.entity.User;
import com.samsung.airbnb.enums.Gender;
import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Gender gender;
    private Integer age;
}
