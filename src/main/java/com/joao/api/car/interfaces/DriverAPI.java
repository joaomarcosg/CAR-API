package com.joao.api.car.interfaces;

import com.joao.api.car.domain.Driver;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class DriverAPI {

    @GetMapping("/drivers")
    public List<Driver> listDrivers() {
        return new ArrayList<>();
    }
}
