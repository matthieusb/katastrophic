package org.matthieusb.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.matthieusb.kata.Wrapper.wrap;

public class WrapperTest {
    @Test
    void shouldNotWrapWithoutSentence() {
        assertThat(wrap(null, 4))
                .isNull();
    }

    @Test
    void shouldNotWrapWithShortEnoughSentence() {
        assertThat(wrap("text", 4))
                .isEqualTo("text");
    }

    @Test
    void shouldWrapBySplittingByWord() {
        assertThat(wrap("text", 2))
                .isEqualTo(join("te", "xt"));

        assertThat(wrap("text", 1))
                .isEqualTo(join("t", "e", "x", "t"));
    }

    @Test
    void shouldWrapBySplittingBetweenWords() {
        assertThat(wrap("text text text", 5))
                .isEqualTo(join("text", "text", "text"));
    }

    @Test
    void shouldWrapBySplittingOnLastPossibleWord() {
        assertThat(wrap("text text text", 10))
                .isEqualTo(join("text text", "text"));
    }

    private static String join(String... args) {
        return String.join("\n", args);
    }
}
