package com.flight.mock.api.mockApi.services;

import com.flight.mock.api.mockApi.entities.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FlightService {


    private final AirportService airportService;

    public FlightService(AirportService airportService) {
        this.airportService = airportService;
    }
    /*
     * Bu metot çağrıldığında güncel tarihten başlayıp önümüzdeki 15 gün aralığında
     * 300 adet mock Flight nesnesi göndersin.
     */
    public List<Flight> getFlights() {
        var resultList = new ArrayList<Flight>();
        var airports = airportService.findAll();
        var len = airports.size();



        for (var i = 0; i < 301; i++) {

            var idsAndPrice = getRandomIdsAndPrice(len);
            var dates = getRandomDates();

            System.out.println(Arrays.toString(idsAndPrice));
            var flight = new Flight();
            flight.setId((long) i);
            flight.setDepartureAirport(airportService.getById(idsAndPrice[0]).getName());
            flight.setArrivalAirport(airportService.getById(idsAndPrice[1]).getName());
            flight.setDepartureDateTime(dates[0]);
            flight.setArrivalDateTime(dates[1]);
            flight.setPrice((double) idsAndPrice[2]);

            resultList.add(flight);
        }

        return resultList;
    }

    public long[] getRandomIdsAndPrice(int bound) {
        var random = new Random();
        var id1 = random.nextInt(bound) + 1;
        int id2;

        do id2 = random.nextInt(2) + 1; while (id1 == id2);

        return new long[] {id1, id2, random.nextInt(2000) + 1000};
    }

    public LocalDateTime[] getRandomDates() {
        var random = new Random();
        var localDateTime = LocalDateTime.now();

        var year = localDateTime.getYear();
        var month = localDateTime.getMonthValue();
        var day = localDateTime.getDayOfMonth();

        var randomDateTime1 = LocalDateTime.of(
                year,                                                       // Yıl
                ThreadLocalRandom.current().nextInt(month, month + 1),       // Ay
                ThreadLocalRandom.current().nextInt(day, 28),         // Gün
                ThreadLocalRandom.current().nextInt(0, 24),     // Saat
                ThreadLocalRandom.current().nextInt(0, 60)      // Dakika
        );

        var hour = random.nextInt(4) + 1;
        var randomDateTime2 = randomDateTime1.plusHours(hour);

        return new LocalDateTime[] {randomDateTime1, randomDateTime2};
    }


}
