package com.meleva.meleva.service;

import com.meleva.meleva.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class MelevaService {

    public MelevaDto getListarHoteis (RequestDto requestDto) {
        //TODO
        // Validar se tem dataInicial, dataFinal, zipCode, tokemAcesso
        // Caso não tenha throw Exception

        String url = "https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=" + requestDto.getCidadeZipCode();

        RestTemplate rest = new RestTemplate();

        //TODO validar se tokem não está inspirado
        //TODO criar função que valida o tokem, ela vai simplesmente retorna true, dentro da mesma uma obs sobre o motivo de nao estar validando

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(requestDto.getTokemAcesso());
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        //TODO colocar dentro de um try catch
        // msg de erro: ocorreu um erro durante a tentativa de fazer a requisição
        ResponseEntity<ResponseDto> response = rest.exchange(url, HttpMethod.GET, entity, ResponseDto.class);

        //TODO validar se response.getBody() != null
        ResponseDto responseBody = response.getBody();

        MelevaDto melevaDto = new MelevaDto();
        melevaDto.setDataInicial(requestDto.getDataInicial());
        melevaDto.setDataFinal(requestDto.getDataFinal());

        List<HotelDto> hoteisDisponiveis = new ArrayList<>();

        //TODO validar se responseBody.getData() != null && tem pelo menos 1 obj dentro
        for (HotelResponseDto hotel: responseBody.getData()
             ) {
            HotelDto hotelDto = new HotelDto();
            hotelDto.setNomeHotel(hotel.getName() == null ? "" : hotel.getName());
            hotelDto.setEndecoHotel(hotel.getAddress() == null ? "" : hotel.getAddress().getCountryCode());
            hoteisDisponiveis.add(hotelDto);
        }

        melevaDto.setHoteisDisponiveis(hoteisDisponiveis);

        return melevaDto;
    }
}
