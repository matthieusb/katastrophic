package fr.kata;


import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Main Test")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MastermindTest {

    @Test
    void should_give_victory_feedback() {
        assertThat(new Mastermind(new Combination(Color.RED, Color.RED, Color.RED, Color.RED))
                .giveFeedback(new Combination(Color.RED, Color.RED, Color.RED, Color.RED)))
                .isEqualTo(new Feedback(4, 0));
    }

    @Test
    void should_give_all_pins_incorrect_feedback() {
        assertThat(new Mastermind(new Combination(Color.RED, Color.RED, Color.RED, Color.RED))
                .giveFeedback(new Combination(Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE)))
                .isEqualTo(new Feedback(0, 0));
    }
}