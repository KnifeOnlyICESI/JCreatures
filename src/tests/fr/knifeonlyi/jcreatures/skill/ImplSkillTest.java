package fr.knifeonlyi.jcreatures.skill;

import fr.knifeonlyi.jcreatures.skill.impl.ImplSkill;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplSkillTest {

    private static final String NAME = "Life+";
    private static final Integer VALUE = 20;
    private static final Caracteristic CARACTERISTIC = Caracteristic.CHANGE_LIFE;

    private AbstractSkill skill;

    @Before
    public void setUp() {
        this.skill = new ImplSkill(ImplSkillTest.NAME, ImplSkillTest.VALUE, ImplSkillTest.CARACTERISTIC);
    }

    @Test
    public void testSetName() {
        assertEquals(ImplSkillTest.NAME, this.skill.getName());
    }

    @Test
    public void testSetValue() {
        assertEquals(ImplSkillTest.VALUE, this.skill.getValue());
    }

    @Test
    public void testSetCaracteristic() {
        assertEquals(ImplSkillTest.CARACTERISTIC, this.skill.getCaracteristic());
    }
}
