package com.techelevator.dao;

import com.techelevator.model.City;

import java.util.ArrayList;
import java.util.List;

public class InMemoryCityDao implements CityDao {


    City maryCity;

    public InMemoryCityDao() {
        maryCity = new City();
        maryCity.setCityName("Mary's City");
        maryCity.setCityId(1);
        maryCity.setArea(20);
        maryCity.setPopulation(25);
    }

    @Override
    public City getCity(long cityId) {
        return maryCity;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        List<City> list = new ArrayList<>();
        list.add(maryCity);
        return list;
    }

    @Override
    public City createCity(City city) {
        return maryCity;
    }

    @Override
    public void updateCity(City city) {
        // Mary's city is already perfect
    }

    @Override
    public void deleteCity(long cityId) {
        // Mary's city is already perfect so why would you get rid of it?!
    }
}
