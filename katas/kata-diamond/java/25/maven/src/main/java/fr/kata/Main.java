package fr.kata;

public class Main {
    static final int A_CHARACTER_CODE = 65;

    public static String printDiamond(char character) {
        return "A";
    }

    public static String printDiamondFirstLine(char character) {
        StringBuilder builder = new StringBuilder();

        int characterCode = character;

        builder.append("/");



        builder.append("/");

        return builder.toString();
    }
}