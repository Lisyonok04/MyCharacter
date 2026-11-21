package ru.mycharacter.helper;

public final class CharacterFormulaHelper {

    private static final int BASE_LEVEL_XP = 100;
    private static final double LEVEL_EXPONENT = 1.5;

    private CharacterFormulaHelper() {
    }

    /**
     * Суммарный XP, необходимый для достижения уровня.
     * Уровень 1 начинается с 0 XP, уровень 2 — со 100 XP, уровень 3 — с 283 XP и т.д.
     */
    public static int calculateLevelThreshold(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Character level must be at least 1");
        }
        return (int) Math.floor(BASE_LEVEL_XP * Math.pow(level - 1, LEVEL_EXPONENT));
    }

    /**
     * Уровень, который соответствует накопленному суммарному XP.
     */
    public static int calculateLevel(int totalXp) {
        if (totalXp < 0) {
            throw new IllegalArgumentException("Total XP must not be negative");
        }
        int level = 1;
        while (calculateLevelThreshold(level + 1) <= totalXp) {
            level++;
        }
        return level;
    }

    /**
     * Суммарный XP, необходимый для перехода на следующий уровень.
     */
    public static int calculateNextLevelXp(int currentLevel) {
        return calculateLevelThreshold(currentLevel + 1);
    }

    /**
     * Сколько XP набрано внутри текущего уровня.
     */
    public static int calculateXpIntoLevel(int totalXp, int level) {
        return Math.max(0, totalXp - calculateLevelThreshold(level));
    }

    /**
     * Сколько XP нужно набрать внутри текущего уровня до следующего.
     */
    public static int calculateXpForNextLevel(int level) {
        return calculateNextLevelXp(level) - calculateLevelThreshold(level);
    }

    /**
     * Прогресс до следующего уровня в процентах (0-100).
     */
    public static int calculateProgressPercent(int totalXp, int level) {
        int xpForNextLevel = calculateXpForNextLevel(level);
        if (xpForNextLevel <= 0) {
            return 100;
        }
        int xpIntoLevel = calculateXpIntoLevel(totalXp, level);
        return Math.min(100, (int) Math.floor(xpIntoLevel * 100.0 / xpForNextLevel));
    }
}
