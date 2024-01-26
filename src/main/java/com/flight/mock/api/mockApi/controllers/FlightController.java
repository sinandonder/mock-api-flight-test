package com.flight.mock.api.mockApi.controllers;

import com.flight.mock.api.mockApi.entities.Flight;
import com.flight.mock.api.mockApi.services.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }



}
