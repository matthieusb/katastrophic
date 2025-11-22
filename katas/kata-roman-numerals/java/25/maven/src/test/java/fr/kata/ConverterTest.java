package fr.kata;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class ConverterTest {
    // -- Part 1
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "14, XIV",
            "49, XLIX",
            "492, CDXCII",
            "567, DLXVII",
            "1958, MCMLVIII"
    })
    void shouldConvertArabicToRomanForOne(int arabic, String roman) {
        assertThat(new Converter().arabicToRoman(arabic))
                .isEqualTo(roman);
    }

    // -- Part 2
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "14, XIV",
            "49, XLIX",
            "492, CDXCII",
            "567, DLXVII",
            "1958, MCMLVIII"
    })
    public void shouldConvertRomanToArabicForOne(int arabic, String roman) {
        assertThat(new Converter().romanToArabic(roman))
            .isEqualTo(arabic);
    }
}
