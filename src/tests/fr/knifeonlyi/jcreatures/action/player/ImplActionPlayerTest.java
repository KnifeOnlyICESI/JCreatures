package fr.knifeonlyi.jcreatures.action.player;

import fr.knifeonlyi.jcreatures.action.player.impl.ImplActionPlayer;
import fr.knifeonlyi.jcreatures.creature.Creature;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.Caracteristic;
import fr.knifeonlyi.jcreatures.skill.Skill;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ImplActionPlayerTest {

    private static final String SKILL_NAME = "Skill #1";
    private static final String CREATURE_NAME = "Creature #1";
    private static final Integer NB_ACTIONS = 1;

    private static ActionPlayerInterface actionPlayer;
    private static List<SkillInterface> skills;
    private static List<CreatureInterface> creatures;
    private static List<String> actions;

    @Before
    public void setUp() {
        actionPlayer = new ImplActionPlayer();
        skills = new ArrayList<>();
        creatures = new ArrayList<>();
        actions = new ArrayList<>();

        skills.add(new Skill(SKILL_NAME, 20, Caracteristic.CHANGE_LIFE));
        creatures.add(new Creature(CREATURE_NAME, 200, 50, 20, skills));
        actions.add("Attack");
    }

    @Test
    public void setChoiceSkill() throws InterruptedException {
        assertEquals(
            String.format("MUST be equals to %s.", SKILL_NAME),
            SKILL_NAME,
            actionPlayer.choiceSkill("", skills).getName()
        );
    }

    @Test
    public void setChoiceCreature() throws InterruptedException {
        assertEquals(
            String.format("MUST be equals to %s.", CREATURE_NAME),
            CREATURE_NAME,
            actionPlayer.choiceCreature("", creatures).getName()
        );
    }

    @Test
    public void setChoiceAction() throws InterruptedException {
        assertEquals(
            String.format("MUST be equals to %s.", (NB_ACTIONS - 1)),
            (NB_ACTIONS - 1),
            (int) actionPlayer.choiceAction("", actions)
        );
    }
}
