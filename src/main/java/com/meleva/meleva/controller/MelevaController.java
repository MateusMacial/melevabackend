package com.meleva.meleva.controller;

import com.meleva.meleva.dto.MelevaDto;
import com.meleva.meleva.dto.RequestDto;
import com.meleva.meleva.service.MelevaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/meleva")
@RestController
public class MelevaController {

    @Autowired
    private MelevaService melevaService;

    @RequestMapping(value = "/get-page", method = RequestMethod.POST)
    public MelevaDto listarHoteis(@RequestBody RequestDto requestDto) throws Exception {
        try {
            return melevaService.getListarHoteis(requestDto);
        } catch (Exception e) {
            throw e;
        }
    }
}
