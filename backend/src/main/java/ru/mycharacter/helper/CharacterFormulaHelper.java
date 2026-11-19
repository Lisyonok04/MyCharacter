package ru.mycharacter.helper;

public final class CharacterFormulaHelper {

    private static final int BASE_LEVEL_XP = 100;
    private static final double LEVEL_EXPONENT = 1.5;

    private CharacterFormulaHelper() {
    }

    public static int calculateNextLevelXp(int currentLevel) {
        if (currentLevel < 1) {
            throw new IllegalArgumentException("Character level must be at least 1");
        }
        return (int) (BASE_LEVEL_XP * Math.pow(currentLevel, LEVEL_EXPONENT));
    }
}