package org.matthieusb.kata;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @DisplayName("Arabic to Roman number converion")
    @ParameterizedTest(name = "{0} should be converted to \"{1}\" roman numeral")
    @CsvSource( { "1, I", "2, II", "3, III", "4, IV", "5, V", "9, IX", "12, XII", "40, XL", "42, XLII", "50, L", "100, C", "400, CD", "900, CM", "1000, M", "1142, MCXLII"} )
    void should_convert_arabic_to_roman(Integer arabicNumeral, String romanNumeral) {
        // WHEN
        NumberConverter numberConverter = new NumberConverter();

        String romanResult = numberConverter.toRoman(arabicNumeral);

        // THEN
        assertThat(romanResult).isEqualTo(romanNumeral);
    }

    @DisplayName("Arabic to Roman number converion")
    @ParameterizedTest(name = "{0} should be converted to \"{1}\" roman numeral")
    @CsvSource( { "1, I", "2, II", "3, III", "4, IV", "5, V", "40, XL", "50, L", "100, C", "400, CD", "900, CM", "1000, M"} )
    @Disabled
    void should_convert_roman_to_arabic(Integer arabicNumeral, String romanNumeral) {
        // WHEN
        NumberConverter numberConverter = new NumberConverter();

        Integer arabicResult = numberConverter.toArabic(romanNumeral);

        // THEN
        assertThat(arabicResult).isEqualTo(arabicNumeral);
    }
}
