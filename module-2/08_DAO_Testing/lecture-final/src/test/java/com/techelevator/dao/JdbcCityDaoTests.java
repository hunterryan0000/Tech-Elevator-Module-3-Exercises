package com.techelevator.dao;

import com.techelevator.model.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JdbcCityDaoTests extends BaseDaoTests {

    private static final City CITY_1 = new City(1, "City 1", "AA", 11,111);
    private static final City CITY_2 = new City(2, "City 2", "BB", 22,222);
    private static final City CITY_4 = new City(4, "City 4", "AA", 44,444);

    private City testCity;

    private JdbcCityDao sut;

    @Before
    public void setup() {
        sut = new JdbcCityDao(dataSource);
        testCity = new City(0, "Test City", "CC", 99, 999);
    }

    @Test
    public void getCity_returns_correct_city_for_id() {
        City city = sut.getCity(1);
        assertCitiesMatch(CITY_1, city);

        city = sut.getCity(2);
        assertCitiesMatch(CITY_2, city);
    }

    @Test
    public void getCity_returns_null_when_id_not_found() {
        City city = sut.getCity(99);
        Assert.assertNull(city);
    }

    @Test
    public void getCitiesByState_returns_all_cities_for_state() {
        List<City> cities = sut.getCitiesByState("AA");
        Assert.assertEquals(2, cities.size());
        assertCitiesMatch(CITY_1, cities.get(0));
        assertCitiesMatch(CITY_4, cities.get(1));

        cities = sut.getCitiesByState("BB");
        Assert.assertEquals(1, cities.size());
        assertCitiesMatch(CITY_2, cities.get(0));
    }

    @Test
    public void getCitiesByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<City> cities = sut.getCitiesByState("XX");
        Assert.assertEquals(0, cities.size());
    }

    @Test
    public void createCity_returns_city_with_id_and_expected_values() {
        City createdCity = sut.createCity(testCity);

        long newId = createdCity.getCityId();
        // Don't test for a specific ID value, just make sure it is set
        // This allows for later changes to the test setup script without causing errors unnecessarily in other tests
        Assert.assertTrue(newId > 0);

        testCity.setCityId(newId);
        assertCitiesMatch(testCity, createdCity);
    }

    @Test
    public void created_city_has_expected_values_when_retrieved() {
        City createdCity = sut.createCity(testCity);

        long newId = createdCity.getCityId();
        City retrievedCity = sut.getCity(newId);

        assertCitiesMatch(createdCity, retrievedCity);
    }

    @Test
    public void updated_city_has_expected_values_when_retrieved() {
        // Using other methods that aren't "under test" is a bit more acceptable in integration test
        // Generally we try to avoid this in unit tests, but there can be A LOT more setup and
        // fragility in avoiding it this in integration tests
        City cityToUpdate = sut.getCity(1);

        cityToUpdate.setCityName("Updated");
        cityToUpdate.setStateAbbreviation("CC");
        cityToUpdate.setPopulation(99);
        cityToUpdate.setArea(999);

        sut.updateCity(cityToUpdate);

        City retrievedCity = sut.getCity(1);
        assertCitiesMatch(cityToUpdate, retrievedCity);
    }

    @Test
    public void deleted_city_cant_be_retrieved() {
        sut.deleteCity(4);

        // Make sure we can't pull back the deleted city by ID
        City retrievedCity = sut.getCity(4);
        Assert.assertNull(retrievedCity);

        // Make sure the association to the state was also removed (city 4 previously belonged to state AA)
        // If there were multiple ways to get at the deleted data, make sure they all no longer work
        List<City> cities = sut.getCitiesByState("AA");
        Assert.assertEquals(1, cities.size());
        assertCitiesMatch(CITY_1, cities.get(0));
    }

    private void assertCitiesMatch(City expected, City actual) {
        Assert.assertEquals(expected.getCityId(), actual.getCityId());
        Assert.assertEquals(expected.getCityName(), actual.getCityName());
        Assert.assertEquals(expected.getStateAbbreviation(), actual.getStateAbbreviation());
        Assert.assertEquals(expected.getPopulation(), actual.getPopulation());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
    }
}
