package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
        @Test

        public void test_if_party_is_successful_based_on_cigar_count(){
            CigarParty cigarPartyTest = new CigarParty();

            Assert.assertFalse(cigarPartyTest.haveParty(-4, false));
            Assert.assertTrue(cigarPartyTest.haveParty(45, false));
            Assert.assertFalse(cigarPartyTest.haveParty(1000, false));
            Assert.assertFalse(cigarPartyTest.haveParty(0, true));
            Assert.assertTrue(cigarPartyTest.haveParty(50, true));
            Assert.assertTrue(cigarPartyTest.haveParty(70, false));
        }
}
