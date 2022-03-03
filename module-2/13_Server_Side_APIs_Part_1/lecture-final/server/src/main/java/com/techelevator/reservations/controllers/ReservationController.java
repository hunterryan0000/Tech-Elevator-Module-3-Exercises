package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// The RestController annotation tells Spring to look inside this class for RequestMappings.
// It is really easy to forget! If you are getting 404s, make sure that you have this!
@RestController
public class ReservationController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public ReservationController() {
        // Setting up our DAOs to access our model data
        hotelDao = new MemoryHotelDao();
        reservationDao = new MemoryReservationDao(hotelDao);
    }

    // Setup a mapping for /reservations to GET all reservations from the system
    @RequestMapping(path="/reservations", method = RequestMethod.GET)
    public List<Reservation> getAllReservations() {
        return reservationDao.findAll();
    }

    // Setup a mapping for /reservations/1 to GET the reservation with id=1
    // the id should be a variable! we should be able to get any reservation by id
    // Note the @PathVariable annotation says the id value comes from the request URL
    @RequestMapping(path="/reservations/{id}", method = RequestMethod.GET)
    public Reservation getReservationById(@PathVariable int id) {
        return reservationDao.get(id);
    }

    // Setup a mapping to add a reservation for a hotel at /reservations for POST
    // Note the @RequestBody annotations says the Reservation data comes in the body
    @RequestMapping(path="/reservations", method = RequestMethod.POST)
    public Reservation addNewReservation(@RequestBody Reservation newReservation) {
        return reservationDao.create(newReservation, newReservation.getHotelID());
    }


}
