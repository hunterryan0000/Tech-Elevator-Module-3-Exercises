package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        Hotel[] hotels = restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
        return hotels;
    }

    public Review[] listReviews() {
        return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
        Hotel hotelFromId = restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
        return hotelFromId;
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        // This uses a url query parameter - part of the url path itself is a variable
        // http://localhost:3000/hotels/1/reviews, http://localhost:3000/hotels/1010/reviews, http://localhost:3000/hotels/12345/reviews
        // The expected part of the path can vary, BUT it must be that expected part
//        return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reviews", Review[].class);

        // This uses a query string - ? followed by key / value pairs
        // query strings are a little bit more flexible
        // http://localhost:3000/reviews?hotelID=1
        return restTemplate.getForObject(API_BASE_URL + "reviews?hotelID=" + hotelId, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        // Query string to narrow down the type of hotels we want to get back
        return restTemplate.getForObject(API_BASE_URL + "hotels?stars=3", Hotel[].class);

    }

    public City getWithCustomQuery(){
        return null;
    }

}
