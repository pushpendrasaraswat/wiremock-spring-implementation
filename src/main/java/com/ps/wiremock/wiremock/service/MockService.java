package com.ps.wiremock.wiremock.service;

import com.ps.wiremock.wiremock.dto.CityDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MockService {

    @Value("${mock.server.url}")
    private String mockUrl;

    private final RestTemplate restTemplate;

    public MockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<CityDTO> getAllCity(){
        ResponseEntity<List<CityDTO>> response=restTemplate.exchange(
                mockUrl,
                HttpMethod.GET,
                null,  // No body needed for a GET request
                new ParameterizedTypeReference<List<CityDTO>>() {}
        );
        return response.getBody();

    }


}
