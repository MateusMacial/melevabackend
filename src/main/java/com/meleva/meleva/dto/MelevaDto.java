package com.meleva.meleva.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MelevaDto {
    private String dataInicial;
    private String dataFinal;
    private List<HotelDto> hoteisDisponiveis;
}