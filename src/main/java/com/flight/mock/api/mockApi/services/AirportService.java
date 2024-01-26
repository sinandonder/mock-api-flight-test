package com.flight.mock.api.mockApi.services;

import com.flight.mock.api.mockApi.entities.Airport;
import com.flight.mock.api.mockApi.entities.Flight;
import com.flight.mock.api.mockApi.repositories.AirportRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AirportService {

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> findAll() {
        return this.airportRepository.findAll();
    }

    public Airport add(Airport airport) {
        return this.airportRepository.save(airport);
    }

    public void delete(Long id) {
        airportRepository.deleteById(id);
    }

    public Airport getById(Long id) {
       return airportRepository.findById(id).orElse(null);
    }

}
