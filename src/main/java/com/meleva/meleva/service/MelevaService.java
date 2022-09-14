package com.meleva.meleva.service;

import com.meleva.meleva.dto.HotelDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MelevaService {

    public String getListarHoteis () {
        String teste = "Teste";

        String url = "https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=PAR";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("ki5ngESXLEn0GePLwQCI51Gs0lap");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        Object response = rest.exchange(url, HttpMethod.GET, entity, Object.class);

        /*List<HotelDto> hoteisDisponiveis = new ArrayList<>();
        for (Object hotel: response
             ) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setNome("");
            hotelDto.setEndereco("");
            hoteisDisponiveis.add(hotelDto);
        }*/

        return teste;
    }
}
