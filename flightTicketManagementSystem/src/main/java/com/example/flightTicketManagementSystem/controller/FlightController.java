package com.example.flightTicketManagementSystem.controller;

import com.example.flightTicketManagementSystem.dto.FlightDTO;
import com.example.flightTicketManagementSystem.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class FlightController {
    @Autowired
    private FlightService flightService;


    @GetMapping("/showflightDetails/{id}")
    ResponseEntity<FlightDTO> showflightDetails(@PathVariable int id) {
        FlightDTO flightDTO = flightService.showFlightDetails(id).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(flightDTO);
    }
    @PostMapping("/updateAvailableSeats/{id}")
    void updateAvailableSeats(@PathVariable int id)
    {
        flightService.updateAvailableSeats(id);
    }

    @GetMapping("/showflightDetailsBasedOnDepartureAndArrivalAndDepartureTime")
    ResponseEntity<List<FlightDTO>> showflightDetailsDAD(@RequestParam Integer departure,
                                                         @RequestParam Integer arrival, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate) {
        List<FlightDTO> flightDTO = flightService.showFlightDetailsDAD(departure,arrival,departureDate).getBody();
        return ResponseEntity.status(HttpStatus.OK).body(flightDTO);
    }

}
