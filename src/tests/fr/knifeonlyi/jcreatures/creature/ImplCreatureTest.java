package fr.knifeonlyi.jcreatures.creature;

import fr.knifeonlyi.jcreatures.skill.SkillInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImplCreatureTest {

    private static final String CREATURE1_NAME = "Dragon";
    private static final Integer CREATURE1_HP = 20;
    private static final Integer CREATURE1_AP = 20;
    private static final Integer CREATURE1_STRENGTH = 50;
    private static final Integer NB_SKILLS_CREATURE1 = 5;

    private static final String CREATURE2_NAME = "Hunter";
    private static final Integer CREATURE2_HP = 100;
    private static final Integer CREATURE2_AP = 10;
    private static final Integer CREATURE2_STRENGTH = 30;
    private static final Integer NB_SKILLS_CREATURE2 = 10;

    private CreatureInterface creature1;
    private CreatureInterface creature2;

    @Before
    public void setUp() {
        List<SkillInterface> skillsCreature1 = new ArrayList<>();
        List<SkillInterface> skillsCreature2 = new ArrayList<>();

        for (int i = 0; i < ImplCreatureTest.NB_SKILLS_CREATURE1; i++) {
            skillsCreature1.add(null);
        }

        for (int i = 0; i < ImplCreatureTest.NB_SKILLS_CREATURE2; i++) {
            skillsCreature2.add(null);
        }

        this.creature1 = new Creature(
            ImplCreatureTest.CREATURE1_NAME,
            ImplCreatureTest.CREATURE1_HP,
            ImplCreatureTest.CREATURE1_AP,
            ImplCreatureTest.CREATURE1_STRENGTH,
            skillsCreature1
        );

        this.creature2 = new Creature(
            ImplCreatureTest.CREATURE2_NAME,
            ImplCreatureTest.CREATURE2_HP,
            ImplCreatureTest.CREATURE2_AP,
            ImplCreatureTest.CREATURE2_STRENGTH,
            skillsCreature2
        );
    }

    @Test
    public void testSetName() {
        assertEquals(ImplCreatureTest.CREATURE1_NAME, this.creature1.getName());
    }

    @Test
    public void testSetHP() {
        assertEquals(ImplCreatureTest.CREATURE1_HP, this.creature1.getHP());
    }

    @Test
    public void testSetAP() {
        assertEquals(ImplCreatureTest.CREATURE1_AP, this.creature1.getAP());
    }

    @Test
    public void testSetStrength() {
        assertEquals(ImplCreatureTest.CREATURE1_STRENGTH, this.creature1.getStrength());
    }

    @Test
    public void testSetSkills() {
        assertEquals((int) ImplCreatureTest.NB_SKILLS_CREATURE1, this.creature1.getSkills().size());
    }

    @Test
    public void testAttack() {
        int nbLifeAfterAttack = (this.creature2.getHP() - this.creature1.getStrength());

        this.creature1.attack(this.creature2);

        assertEquals(nbLifeAfterAttack, (int) this.creature2.getHP());
    }

    @Test
    public void testIsAlive() {
        assertEquals(true, this.creature1.isAlive());

        this.creature1.setHP(0);

        assertEquals(false, this.creature1.isAlive());
    }
}
