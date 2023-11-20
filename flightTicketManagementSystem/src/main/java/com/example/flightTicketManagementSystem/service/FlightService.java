package com.example.flightTicketManagementSystem.service;

import com.example.flightTicketManagementSystem.dto.FlightDTO;
import com.example.flightTicketManagementSystem.entity.AirportEntity;
import com.example.flightTicketManagementSystem.entity.FlightEntity;
import com.example.flightTicketManagementSystem.repo.AirportRepo;
import com.example.flightTicketManagementSystem.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    private FlightRepo flightRepo;
    @Autowired private AirportRepo airportRepo;
//    public ResponseEntity<FlightDTO> showFlightDetails(int id){
//        FlightEntity flightEntity=flightRepo.findById(id).get();
//        FlightDTO flightDTO=new FlightDTO();
//        AirportEntity arrivalAirportDetails=airportRepo.findById()
//        flightDTO.setFlightId(flightEntity.getFlightId());
//        flightDTO.setFlightNumber(flightEntity.getFlightNumber());
//        flightDTO.setAvailableSeats(flightEntity.getAvailableSeats());
//        flightDTO.setDuration(flightEntity.getDuration());
//        flightDTO.setAirlineEntityName(flightEntity.getAirlineEntity().getAirlineName());
//        flightDTO.setArrivalAirportName(flightEntity.getArrivalAirport().getAirportName());
//        flightDTO.setDepartureAirportName(flightEntity.getDepartureAirport().getAirportName());
//        flightDTO.setArrivalDateTime(flightEntity.getArrivalDateTime());
//        flightDTO.setDepartureDateTime(flightEntity.getDepartureDateTime());
//        return ResponseEntity.status(HttpStatus.OK).body(flightDTO);
//
//    }
//    public ResponseEntity<List<FlightDTO>> showFlightDetailsDAD(int departure, int arrival, Date departureDate){
//        List<FlightDTO> flightEntity=flightRepo.findByDepartureAndArrivalAndDepartureDate(departure,arrival,departureDate).stream().map(this::converFlightDTO).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(flightEntity);
//
//    }
//    FlightDTO converFlightDTO(FlightEntity flightEntity)
//    {
//        FlightDTO flightDTO=new FlightDTO();
//        flightDTO.setFlightId(flightEntity.getFlightId());
//        flightDTO.setFlightNumber(flightEntity.getFlightNumber());
//        flightDTO.setAvailableSeats(flightEntity.getAvailableSeats());
//        flightDTO.setDuration(flightEntity.getDuration());
//        flightDTO.setAirlineEntityName(flightEntity.getAirlineEntity().getAirlineName());
//        flightDTO.setArrivalAirportName(flightEntity.getArrivalAirport().getAirportName());
//        flightDTO.setDepartureAirportName(flightEntity.getDepartureAirport().getAirportName());
//        flightDTO.setArrivalDateTime(flightEntity.getArrivalDateTime());
//        flightDTO.setDepartureDateTime(flightEntity.getDepartureDateTime());
//        flightDTO.setDepartureDate(flightEntity.getDepartureDate());
//        return flightDTO;
//    }

    public void updateAvailableSeats(int id) {
        if(flightRepo.findById(id).get().getAvailableSeats()>0){
            FlightEntity flightEntity=flightRepo.findById(id).get();
            flightEntity.setAvailableSeats(flightEntity.getAvailableSeats()-1);
            flightRepo.save(flightEntity);}
    }

    public ResponseEntity<List<FlightEntity>> showFlightDetailsDAD(Integer departure, Integer arrival, Date departureDate) {
        List<FlightEntity> s= flightRepo.findByDepartureAndArrivalAndDepartureDate(departure,arrival,departureDate);
        return ResponseEntity.status(HttpStatus.OK).body(s);
//
    }
}