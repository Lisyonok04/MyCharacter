package ru.mycharacter;

import org.junit.jupiter.api.Test;
import ru.mycharacter.helper.CharacterFormulaHelper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharacterFormulaHelperTest {

    @Test
    void shouldCalculateLevelFromTotalXp() {
        assertEquals(1, CharacterFormulaHelper.calculateLevel(0));
        assertEquals(1, CharacterFormulaHelper.calculateLevel(99));
        assertEquals(2, CharacterFormulaHelper.calculateLevel(100));
        assertEquals(2, CharacterFormulaHelper.calculateLevel(250));
        assertEquals(3, CharacterFormulaHelper.calculateLevel(282));
        assertEquals(3, CharacterFormulaHelper.calculateLevel(300));
    }

    @Test
    void shouldCalculateProgressInsideLevel() {
        assertEquals(18, CharacterFormulaHelper.calculateXpIntoLevel(300, 3));
        assertEquals(237, CharacterFormulaHelper.calculateXpForNextLevel(3));
        assertEquals(7, CharacterFormulaHelper.calculateProgressPercent(300, 3));
        assertEquals(519, CharacterFormulaHelper.calculateNextLevelXp(3));
    }

    @Test
    void shouldRejectInvalidValues() {
        assertThrows(IllegalArgumentException.class, () -> CharacterFormulaHelper.calculateLevel(-1));
        assertThrows(IllegalArgumentException.class, () -> CharacterFormulaHelper.calculateLevelThreshold(0));
    }
}
