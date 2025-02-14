package com.ps.wiremock.wiremock.controller;

import com.ps.wiremock.wiremock.dto.CityDTO;
import com.ps.wiremock.wiremock.service.MockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class MockController {

    private final MockService mockService;

    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping("/call-mock")
    @ResponseBody
    List<CityDTO> getAllCities(){
        return mockService.getAllCity();
    }
}
