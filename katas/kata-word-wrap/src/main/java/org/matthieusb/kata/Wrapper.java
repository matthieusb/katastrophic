package org.matthieusb.kata;

public class Wrapper {
    private static final String LINE_BREAK = "\n";
    private static final char SPACE = ' ';

    private final int columns;

    private Wrapper(int columns) {
        this.columns = columns;
    }

    private String wrap(String sentence) {
        if (isShortEnough(sentence)) {
            return sentence;
        }

        String left = sentence.substring(0, columns);
        int spaceIndex = left.lastIndexOf(SPACE);
        if (spaceIndex != -1) {
            return wrapBySplittingBetweenWords(sentence, spaceIndex);
        }

        return wrapBySplittingOnWords(sentence, left);
    }

    private String wrapBySplittingBetweenWords(String sentence, int spaceIndex) {
        return join(
                sentence.substring(0, spaceIndex),
                wrap(sentence.substring(spaceIndex + 1))
        );
    }

    private String wrapBySplittingOnWords(String sentence, String left) {
        return join(left, wrap(sentence.substring(columns)));
    }

    public static String wrap(String sentence, int columns) {
        return new Wrapper(columns).wrap(sentence);
    }

    private boolean isShortEnough(String sentence) {
        return sentence == null || sentence.length() <= columns;
    }

    private static String join(String left, String right) {
        return left + LINE_BREAK + right;
    }
}
