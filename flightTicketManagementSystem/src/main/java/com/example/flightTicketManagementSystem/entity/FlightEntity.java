package com.example.flightTicketManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;

    @ManyToOne
    @JoinColumn(name="airline_id")
    @JsonBackReference
    private AirlineEntity airlineEntity;
    @ManyToOne
    @JoinColumn(name = "departureAirportIdReference")
    private AirportEntity departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrivalAirportIdReference")
    private AirportEntity arrivalAirport;
    private int flightNumber;
    private Date departureDateTime;
    private Date arrivalDateTime;

    @Column(name = "new_date_column", columnDefinition = "DATE")
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public AirlineEntity getAirlineEntity() {
        return airlineEntity;
    }

    public void setAirlineEntity(AirlineEntity airlineEntity) {
        this.airlineEntity = airlineEntity;
    }

    public AirportEntity getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportEntity departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportEntity getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportEntity arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(Date arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    private int duration;
    private int availableSeats;


}
