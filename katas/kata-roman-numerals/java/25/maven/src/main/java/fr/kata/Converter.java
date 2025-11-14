package fr.kata;

import java.util.Map;
import java.util.Optional;

public class Converter {
    public String arabicToRoman(int arabic) {
        if (arabic >= 1000) {
            return "M" + arabicToRoman(arabic - 1000);
        }
        if (arabic >= 900) {
            return "CM" + arabicToRoman(arabic - 900);
        }
        if (arabic >= 500) {
            return "D" + arabicToRoman(arabic - 500);
        }
        if (arabic >= 400) {
            return "CD" + arabicToRoman(arabic - 400);
        }
        if (arabic >= 100) {
            return "C" + arabicToRoman(arabic - 100);
        }
        if (arabic >= 90) {
            return "XC" + arabicToRoman(arabic - 90);
        }
        if (arabic >= 50) {
            return "L" + arabicToRoman(arabic - 50);
        }
        if (arabic >= 40) {
            return "XL" + arabicToRoman(arabic - 40);
        }
        if (arabic >= 10) {
            return "X" + arabicToRoman(arabic - 10);
        }
        if (arabic >= 9) {
            return "IX" + arabicToRoman(arabic - 9);
        }
        if (arabic >= 5) {
            return "V" + arabicToRoman(arabic - 5);
        }
        if (arabic >= 4) {
            return "IV" + arabicToRoman(arabic - 4);
        }
        if (arabic >= 1) {
            return "I" + arabicToRoman(arabic - 1);
        }
        return "";
    }

    Map<String, Integer> romanToArabicNormalMappings = Map.of(
            "I", 1,
            "V", 5,
            "X", 10,
            "L", 50,
            "C", 100,
            "D", 500,
            "M", 1000
    );

    Map<String, Integer> romanToArabicSpecialMappings = Map.of(
            "IV", 4,
            "IX", 9,
            "XL", 40,
            "XC", 90,
            "CD", 400,
            "CM", 900
    );

    // NOTE: This is not the clearest implementation, could be improved
    public Integer romanToArabic(String roman) {
        Optional<String> currentLetter = extractNormalLetter(roman);
        Optional<String> currentSpecialLetters = extractSpecialLetters(roman);

        if (currentSpecialLetters.isPresent()) {
            return romanToArabicSpecialMappings.get(currentSpecialLetters.get())
                    + romanToArabic(roman.substring(2));
        } else {
            if (currentLetter.isPresent()) {
                return romanToArabicNormalMappings.get(currentLetter.get()) + romanToArabic(roman.substring(1));
            }
        }

        return 0;
    }

    private Optional<String> extractNormalLetter(String roman) {
        if (roman.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(roman.substring(0, 1));
    }

    private Optional<String> extractSpecialLetters(String roman) {
        if (roman.length() < 2) {
            return Optional.empty();
        }
        String specialLetters = roman.substring(0, 2);

        if (romanToArabicSpecialMappings.get(specialLetters) != null) {
            return Optional.of(specialLetters);
        }

        return Optional.empty();
    }
}
