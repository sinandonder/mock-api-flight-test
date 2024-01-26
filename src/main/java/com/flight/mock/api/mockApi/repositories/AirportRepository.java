package com.flight.mock.api.mockApi.repositories;

import com.flight.mock.api.mockApi.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {


}
