package com.meleva.meleva.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private String cidadeZipCode;
    private String tokemAcesso;
    private String dataInicial;
    private String dataFinal;
}
