package com.meleva.meleva.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDto {
    private List<HotelResponseDto> data;
}
