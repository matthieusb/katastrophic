package org.matthieusb.kata;

public class LeapYear {

    private final int yearNumber;

    public LeapYear(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public boolean isLeap() {
        return isTypical() || isAtypical();
    }

    private boolean isTypical() {
        return yearNumber % 4 == 0 && yearNumber % 100 != 0;
    }

    private boolean isAtypical() {
        return yearNumber % 400 == 0;
    }
}
