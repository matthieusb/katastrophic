package org.matthieusb.kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TennisGameUnitTest {

    @ParameterizedTest
    @CsvFileSource(delimiter = ',', numLinesToSkip = 1, resources = "/param-test-data.csv")
    void checkAllScoresTennisGame1(Integer player1Score, Integer player2Score, String expectedScore) {
        TennisGame1 game = new TennisGame1("player1", "player2");
        checkAllScores(player1Score, player2Score, expectedScore, game);
    }

    @ParameterizedTest
    @CsvFileSource(delimiter = ',', numLinesToSkip = 1, resources = "/param-test-data.csv")
    void checkAllScoresTennisGame2(Integer player1Score, Integer player2Score, String expectedScore) {
        TennisGame2 game = new TennisGame2("player1", "player2");
        checkAllScores(player1Score, player2Score, expectedScore, game);
    }

    @ParameterizedTest
    @CsvFileSource(delimiter = ',', numLinesToSkip = 1, resources = "/param-test-data.csv")
    void checkAllScoresTennisGame3(Integer player1Score, Integer player2Score, String expectedScore) {
        TennisGame3 game = new TennisGame3("player1", "player2");
        checkAllScores(player1Score, player2Score, expectedScore, game);
    }

    private void checkAllScores(Integer player1Score, Integer player2Score, String expectedScore, TennisGame game) {
        int highestScore = Math.max(player1Score, player2Score);

        for (int i = 0; i < highestScore; i++) {
            if (i < player1Score)
                game.wonPoint("player1");
            if (i < player2Score)
                game.wonPoint("player2");
        }

        assertThat(game.calculateScore()).isEqualTo(expectedScore);
    }
}
