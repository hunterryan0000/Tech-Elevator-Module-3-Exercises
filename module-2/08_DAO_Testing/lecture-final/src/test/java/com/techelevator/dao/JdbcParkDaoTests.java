package com.techelevator.dao;

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
        // Aim high with the id's not found, just in case someone adds a little more data later on
        Park park = sut.getPark(999);
        Assert.assertNull(park);
    }

    @Test
    public void getParksByState_returns_all_parks_for_state() {
        // Expect 2 parks, 1 and 3
        List<Park> list = sut.getParksByState("AA");

        // Check that we got 2 parks back in the list
        Assert.assertEquals(2, list.size());

        // Make sure those 2 are parks 1 & 3, should come back in order by park_id
        Park park1 = list.get(0);
        assertParksMatch(PARK_1, park1);
        Park park3 = list.get(1);
        assertParksMatch(PARK_3, park3);
    }

    @Test
    public void getParksByState_returns_empty_list_for_abbreviation_not_in_db() {
        List<Park> list = sut.getParksByState("XX");

        // Always put a message in to be more clear on what is wrong when the test fails
        //Assert.assertNotNull(list);
        Assert.assertNotNull("The list of parks should be empty not null", list);
        // Good practice to ASSERT that something is not null before you call methods on it to avoid NullPointerExceptions
        Assert.assertEquals("The list of parks is expected to be empty", 0, list.size());
    }

    @Test
    public void createPark_returns_park_with_id_and_expected_values() {
        LocalDate dateEstablished = LocalDate.parse("1999-09-09");
        Park newPark = new Park(0, "Test Park", dateEstablished, 99.9, true);
        Park created = sut.createPark(newPark);

        // Did I get a valid ID?
        Assert.assertTrue("We should get a park back with an ID > 0", created.getParkId() > 0);

        // Need to also check that the values are correct
        // Set the ID to the created park id
        // (we didn't know this value ahead of time and don't care exactly what it is)
        newPark.setParkId(created.getParkId());
        assertParksMatch(newPark, created);
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
        sut.deletePark(PARK_3.getParkId());

        // Make sure it is gone...
        Park park = sut.getPark(PARK_3.getParkId());
        Assert.assertNull("Park should be deleted", park);

        // Also make sure it is gone from states AA and CC
        List<Park> listAA = sut.getParksByState("AA");
        Assert.assertNotNull("Should get a list back", listAA);
        Assert.assertEquals("State AA should still have 1 park", 1, listAA.size());

        List<Park> listCC = sut.getParksByState("CC");
        Assert.assertNotNull("Should get a list back", listCC);
        Assert.assertEquals("State CC should have no parks", 0, listCC.size());
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
        // PUT MESSAGES IN!!!! - That way we see which field is incorrect on test failure!
        Assert.assertEquals("Park id does not match", expected.getParkId(), actual.getParkId());
        Assert.assertEquals("Park name does not match", expected.getParkName(), actual.getParkName());
        Assert.assertEquals("Park date established does not match", expected.getDateEstablished(), actual.getDateEstablished());
        Assert.assertEquals("Park area does not match", expected.getArea(), actual.getArea(), 0.1);
        Assert.assertEquals("Park hasCamping does not match", expected.getHasCamping(), actual.getHasCamping());
    }

}
