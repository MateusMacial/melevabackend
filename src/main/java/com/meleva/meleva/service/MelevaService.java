package com.meleva.meleva.service;

import com.meleva.meleva.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Slf4j
@Service
public class MelevaService {

    public MelevaDto getListarHoteis (RequestDto requestDto) throws Exception {
        if (StringUtils.isBlank(requestDto.getCidadeZipCode())) {
            throw new Exception("O código identificador da cidade não foi informado para busca de hoteis.");
        }
        if (StringUtils.isBlank(requestDto.getDataInicial())) {
            throw new Exception("Data inicial para a estádia não foi informada.");
        }
        if (StringUtils.isBlank(requestDto.getDataFinal())) {
            throw new Exception("Data final para a estádia não foi informada.");
        }

        String url = "https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=" + requestDto.getCidadeZipCode();

        RestTemplate rest = new RestTemplate();

        if (StringUtils.isBlank(requestDto.getTokemAcesso())) {
            throw new Exception("Tokem de autentificação não foi informado.");
        } else {
            if (this.validarTokenAcesso(requestDto.getTokemAcesso())){
                throw new Exception("Tokem de autentificação esta expirado.");
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(requestDto.getTokemAcesso());
        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<ResponseDto> response;
        try {
            response = rest.exchange(url, HttpMethod.GET, entity, ResponseDto.class);
        } catch (Exception e) {
            throw new Exception("Ocorreu um erro durante a tentativa de fazer a requisição " + e);
        }

        ResponseDto responseBody;
        if (response.getBody() != null) {
            responseBody = response.getBody();
        } else {
            throw new Exception("A requisição não retornou nenhum valor.");
        }

        MelevaDto melevaDto = new MelevaDto();
        melevaDto.setDataInicial(requestDto.getDataInicial());
        melevaDto.setDataFinal(requestDto.getDataFinal());

        List<HotelDto> hoteisDisponiveis = new ArrayList<>();

        if (responseBody.getData() != null && responseBody.getData().size() >= 1) {
            for (HotelResponseDto hotel : responseBody.getData()
            ) {
                HotelDto hotelDto = new HotelDto();
                hotelDto.setNomeHotel(hotel.getName() == null ? "" : hotel.getName());
                hotelDto.setEnderecoHotel(hotel.getAddress() == null ? "" : hotel.getAddress().getCountryCode());
                hoteisDisponiveis.add(hotelDto);
            }

            melevaDto.setHoteisDisponiveis(hoteisDisponiveis);
        } else {
            throw new Exception("Não encontramos nenhum hotel para a cidade selecionada.");
        }

        return melevaDto;
    }
    private boolean validarTokenAcesso(String tokemAcesso) {
        // Função de validar o tokem está incompleta por ser algo muito díficil se não impossivel de resolver sem os devidos recursos
        return false;
    }
}
