package org.matthieusb.kata;


import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final String ADVANTAGE = "Advantage";
    private static final String WIN_FOR = "Win for";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";
    private static final String ALL = "All";

    private static final Map<Integer, String> SCORES_MAP = Map.of(0, LOVE, 1, FIFTEEN, 2, THIRTY, 3, FORTY);

    private Integer m_score1 = 0;
    private Integer m_score2 = 0;

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (player1.getName().equals(playerName))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String calculateScore() {
        String scoreResult = "";

        if (scoreHasEquality()) {
            scoreResult = calculateEqualityScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            scoreResult = calculateGameEndScore();
        } else {
            scoreResult = calculateMiddleGameScore();
        }

        return scoreResult;
    }

    private boolean scoreHasEquality() {
        return m_score1.equals(m_score2);
    }

    private String calculateMiddleGameScore() {
        return SCORES_MAP.get(m_score1) + "-" + SCORES_MAP.get(m_score2);
    }

    private String calculateGameEndScore() {
        String score;

        int player1AdvantageOverPlayer2 = m_score1 - m_score2;

        if (playerHasAdvantageOverTheOther(player1AdvantageOverPlayer2)) {
            score = ADVANTAGE + " " + (player1AdvantageOverPlayer2 > 0 ? player1 : player2);
        } else {
            score = WIN_FOR + " " + (player1AdvantageOverPlayer2 > 0 ? player1 : player2);
        }

        return score;
    }

    private boolean playerHasAdvantageOverTheOther(int player1AdvantageOverPlayer2) {
        return Math.abs(player1AdvantageOverPlayer2) == 1;
    }

    private String calculateEqualityScore() {
        if (m_score1 >= 3) {
            return "Deuce";
        } else {
            return SCORES_MAP.get(m_score1) + "-" + ALL;
        }
    }
}
