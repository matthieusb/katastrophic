package fr.kata;


import org.junit.jupiter.api.Test;

import static fr.kata.Main.printDiamond;
import static fr.kata.Main.printDiamondFirstLine;
import static org.assertj.core.api.Assertions.assertThat;


public class MainTest {
    @Test
    public void shouldDisplayA() {
        assertThat(printDiamond('A')).isEqualTo("A");
    }

    @Test
    public void shouldDisplayDiamondFirstLineForB() {
        String expected =
            """
            \n A
            """;

        assertThat(printDiamondFirstLine('B')).isEqualTo(expected);
    }

    @Test
    public void shouldDisplayDiamondFirstLineForC() {
        String expected =
                """
                \n  A
                """;

        assertThat(printDiamondFirstLine('C')).isEqualTo(expected);
    }
}
