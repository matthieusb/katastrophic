package org.matthieusb.kata;

public class Player {

    private final String name;
    private final Integer score = 0;

    public Player(String playerName) {
        this.name = playerName;
    }


    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name;
    }
}
