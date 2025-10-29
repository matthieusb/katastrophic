package fr.kata;

import java.util.ArrayList;

public record Mastermind(Combination secret) {

    public Feedback giveFeedback(Combination proposition) {

        var blacks = new ArrayList<Boolean>();

        for(int i = 0; i < 4; i++) {
            blacks.add(proposition.get(i) == secret.get(i));
        }


        return new Feedback((int) blacks.stream().count(), 0);
    }
}
