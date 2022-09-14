package com.meleva.meleva.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class MelevaService {

    public String getListarHoteis () {
        String teste = "Teste";

        String url = "https://test.api.amadeus.com/v1/reference-data/locations/hotels/by-city?cityCode=PAR";

        RestTemplate rest = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("juKNwxCwFa86ORwG9hhtSPjSIZFA");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        Object obj = rest.exchange(url, HttpMethod.GET, entity, Object.class);

        return teste;
    }
}
