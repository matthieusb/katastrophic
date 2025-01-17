package org.matthieusb.kata;

import java.util.NavigableMap;
import java.util.TreeMap;

public class NumberConverter {

    private static final NavigableMap<Integer, String> NUMBER_TO_ROMAN = new TreeMap<>();

    public NumberConverter() {
        NUMBER_TO_ROMAN.put(1000, "M");
        NUMBER_TO_ROMAN.put(900, "CM");
        NUMBER_TO_ROMAN.put(500, "D");
        NUMBER_TO_ROMAN.put(400, "CD");
        NUMBER_TO_ROMAN.put(100, "C");
        NUMBER_TO_ROMAN.put(90, "XC");
        NUMBER_TO_ROMAN.put(50, "L");
        NUMBER_TO_ROMAN.put(40, "XL");
        NUMBER_TO_ROMAN.put(10, "X");
        NUMBER_TO_ROMAN.put(9, "IX");
        NUMBER_TO_ROMAN.put(5, "V");
        NUMBER_TO_ROMAN.put(4, "IV");
        NUMBER_TO_ROMAN.put(1, "I");
    }

    public String toRoman(final Integer arabicNumeral) {
        if (arabicNumeral == 0) {
            return "";
        }

        Integer greatestKeyLessThanOrEqualToArabic = NUMBER_TO_ROMAN.floorKey(arabicNumeral);
        return NUMBER_TO_ROMAN.get(greatestKeyLessThanOrEqualToArabic) +
                toRoman(arabicNumeral - greatestKeyLessThanOrEqualToArabic);
    }

    public Integer toArabic(String romanNumeral) {
        if (romanNumeral.isEmpty()) {
            return 0;
        }


        return null;
    }
}
