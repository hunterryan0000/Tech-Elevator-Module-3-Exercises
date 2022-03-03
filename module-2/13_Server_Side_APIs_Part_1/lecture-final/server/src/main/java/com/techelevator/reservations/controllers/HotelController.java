package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.HotelDao;
import com.techelevator.reservations.dao.MemoryHotelDao;
import com.techelevator.reservations.dao.MemoryReservationDao;
import com.techelevator.reservations.dao.ReservationDao;
import com.techelevator.reservations.model.Hotel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> list() {
        return hotelDao.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDao.get(id);
    }

    /**
     * Return hotels that match by state, and optionally also the city within that state
     *
     * @param state - state to search by
     * @param city - the city (optional) to search by
     * @return all the matching hotels
     */
    // URL for this would be something like /hotels/search?state=MN&city=Minneapolis
    // This uses what is called a query string,
    //    in Spring @RequestParam annotation (can use required=false to make it optional)
    @RequestMapping(path = "/hotels/search", method = RequestMethod.GET)
    public List<Hotel> findByState(@RequestParam String state, @RequestParam(required = false) String city) {
        List<Hotel> allHotels = hotelDao.list();
        List<Hotel> matchingHotels = new ArrayList<>();

        for( Hotel hotel : allHotels ) {
            if (hotel.getAddress().getState().equalsIgnoreCase( state )) {
                // I know the state matches BUT what about the city. If it is set, it also must match
                if (city == null) {
                    // My state matches and the city is not set, so add it to the list
                    matchingHotels.add(hotel);
                } else if (hotel.getAddress().getCity().equalsIgnoreCase( city )) {
                    // My state matches and the city matches, so add it to the list
                    matchingHotels.add(hotel);
                }
            }
        }
        return matchingHotels;
    }

}
