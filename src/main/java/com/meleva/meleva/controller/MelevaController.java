package com.meleva.meleva.controller;

import com.meleva.meleva.service.MelevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RequestMapping(value = "/meleva")
@RestController
public class MelevaController {

    @Autowired
    private MelevaService melevaService;

    @RequestMapping(value = "/get-page", method = RequestMethod.GET)
    public String listarHoteis() {
        return melevaService.getListarHoteis();
    }
    // obj que chega contendo os parametros (HotelDto)
}
