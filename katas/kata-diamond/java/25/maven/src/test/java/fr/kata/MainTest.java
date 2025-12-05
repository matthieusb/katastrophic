package fr.kata;


import org.junit.jupiter.api.Test;

import static fr.kata.Main.printDiamond;
import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {
    @Test
    public void shouldDisplayA() {
        assertThat(printDiamond('A')).isEqualTo("A");
    }

    @Test
    public void shouldDisplayDiamondForB() {
        String expected =
            """
            \n A
            B B
             A
            """;

        assertThat(printDiamond('B')).isEqualTo(expected);
    }
}
