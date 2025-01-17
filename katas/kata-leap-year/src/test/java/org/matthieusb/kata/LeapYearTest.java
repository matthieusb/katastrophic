package org.matthieusb.kata;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LeapYearTest {

    @Test
    void shouldCalculateTypicalCommonYear() {
        LeapYear leapYear = new LeapYear(2001);

        assertThat(leapYear.isLeap()).isFalse();
    }

    @Test
    void shouldCalculateAtypicalCommonYear() {
        LeapYear leapYear = new LeapYear(1900);

        AssertionsForClassTypes.assertThat(leapYear.isLeap()).isFalse();
    }

    @Test
    void shouldCalculateTypicalLeapYear() {
        LeapYear leapYear = new LeapYear(1996);

        assertThat(leapYear.isLeap()).isTrue();
    }

    @Test
    void shouldCalculateAtypicalLeapYear() {
        LeapYear leapYear = new LeapYear(2000);

        assertThat(leapYear.isLeap()).isTrue();
    }
}
