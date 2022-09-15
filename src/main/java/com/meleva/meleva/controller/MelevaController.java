package com.meleva.meleva.controller;

import com.meleva.meleva.dto.HotelDto;
import com.meleva.meleva.dto.MelevaDto;
import com.meleva.meleva.dto.RequestDto;
import com.meleva.meleva.service.MelevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping(value = "/meleva")
@RestController
public class MelevaController {

    @Autowired
    private MelevaService melevaService;

    @RequestMapping(value = "/get-page", method = RequestMethod.POST)
    public MelevaDto listarHoteis(RequestDto requestDto) {
        return melevaService.getListarHoteis(requestDto);
    }
    // obj que chega contendo os parametros (HotelDto)
}
