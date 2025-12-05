package fr.kata;

public class Main {
    static final int A_CHARACTER_CODE = 65;

    public static String printDiamond(char character) {
        StringBuilder result = new StringBuilder();
        result.append("\n");

        int maxCharacterCode = character;
        int numberOfCharacters = maxCharacterCode - A_CHARACTER_CODE + 1;
        int totalNumberOfDiamondLines = numberOfCharacters * 2 - 1;

        for(int i = A_CHARACTER_CODE; i <= maxCharacterCode ; i++) {
            int numberOfSpaceBeforeCharacter = maxCharacterCode - i;
            int numberOfSpaceAfterCharacter = maxCharacterCode - i;


            if (i != A_CHARACTER_CODE) {
                result.append(Character.toString(i));
            }

            for (int j = 0; j < numberOfSpaceBeforeCharacter; j++) {
                result.append(" ");
            }
            result.append(Character.toString(i));

            result.append("\n");
        }

//        for(int i = maxCharacterCode + 1; i <= totalNumberOfDiamondLines ; i++) {
//
//        }



        return result.toString();
    }
}