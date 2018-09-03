package fr.knifeonlyi.jcreatures.skill;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SkillTest {

    private static final String CHANGE_LIFE_MORE_NAME = "Life+";
    private static final Integer CHANGE_LIFE_MORE_VALUE = 20;

    private static final String CHANGE_LIFE_LESS_NAME = "Life-";
    private static final Integer CHANGE_LIFE_LESS_VALUE = -20;

    private static final String CHANGE_ARMOR_MORE_NAME = "Armor+";
    private static final Integer CHANGE_ARMOR_MORE_VALUE = 20;

    private static final String CHANGE_ARMOR_LESS_NAME = "Armor-";
    private static final Integer CHANGE_ARMOR_LESS_VALUE = -20;

    private static final Caracteristic CHANGE_LIFE_CARA = Caracteristic.CHANGE_LIFE;
    private static final Caracteristic CHANGE_ARMOR = Caracteristic.CHANGE_ARMOR;

    private static AbstractSkill changeLifeMore;
    private static AbstractSkill changeLifeLess;
    private static AbstractSkill changeArmorMore;
    private static AbstractSkill changeArmorLess;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testExecute() {
    }
}
