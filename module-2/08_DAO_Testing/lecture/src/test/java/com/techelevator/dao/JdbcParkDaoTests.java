package com.techelevator.dao;

import com.techelevator.model.City;
import com.techelevator.model.Park;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcParkDaoTests extends BaseDaoTests {

    private static final Park PARK_1 =
            new Park(1, "Park 1", LocalDate.parse("1800-01-02"), 100, true);
    private static final Park PARK_2 =
            new Park(2, "Park 2", LocalDate.parse("1900-12-31"), 200, false);
    private static final Park PARK_3 =
            new Park(3, "Park 3", LocalDate.parse("2000-06-15"), 300, false);

    private JdbcParkDao sut;

    @Before
    public void setup() {
        sut = new JdbcParkDao(dataSource);
    }

    @Test
    public void getPark_returns_correct_park_for_id() {
        Park park = sut.getPark(PARK_1.getParkId());
        assertParksMatch(PARK_1, park);
    }

    @Test
    public void getPark_returns_null_when_id_not_found() {
        // Aim high with id's not found, just in case
        //someone adds a little more data later on
        Park park = sut.getPark(999);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        // Expert 2 parks, 1 and 3
        List<Park> list = sut.getParksByState("AA");

        // Check that we got 2 parks back in the list
        Assert.assertEquals(2, list.size());

        //Make sure those 2 are parks 1 & 3, should come back in order by park_id
        Park park1 = list.get(0);
        assertParksMatch(PARK_1, park1);
        Park park3 = list.get(1);
        assertParksMatch(PARK_3, park3);

    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {

    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        Assert.fail();
    }

    @Test
    public void created_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void updated_park_has_expected_values_when_retrieved() {
        Assert.fail();
    }

    @Test
    public void deleted_park_cant_be_retrieved() {

        Assert.fail();
    }

    @Test
    public void park_added_to_state_is_in_list_of_parks_by_state() {
        Assert.fail();
    }

    @Test
    public void park_removed_from_state_is_not_in_list_of_parks_by_state() {
        Assert.fail();
    }

    private void assertParksMatch(Park expected, Park actual) {
        Assert.assertEquals(expected.getParkId(), actual.getParkId());
        Assert.assertEquals(expected.getParkName(), actual.getParkName());
        Assert.assertEquals(expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals(expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals(expected.getHasCamping(), actual.getHasCamping());
    }

}
