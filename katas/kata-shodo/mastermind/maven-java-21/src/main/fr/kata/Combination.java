package fr.kata;

import java.util.Map;

public record Combination(Color color1, Color color2, Color color3, Color color4) {
    public Color get(int i) {
        Map<Integer, Color> colors = Map.of(0, color1, 1, color2, 2, color3, 3, color4);
        return colors.get(i);
    }
}
