package fr.knifeonlyi.jcreatures.creature;

import fr.knifeonlyi.jcreatures.skill.Caracteristic;
import fr.knifeonlyi.jcreatures.skill.Skill;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * The creature factory.
 */
public class CreatureFactory {

    private static final Integer DRAGON_HP = 200;
    private static final Integer DRAGON_AP = 10;
    private static final Integer DRAGON_STRENGTH = 30;

    private static final String DRAGON_FIREBALL_NAME = "Fireball";
    private static final Integer DRAGON_FIREBALL_VALUE = -20;
    private static final String DRAGON_HEAL_NAME = "Heal";
    private static final Integer DRAGON_HEAL_VALUE = 20;

    private static final Integer HUNTER_HP = 100;
    private static final Integer HUNTER_AP = 10;
    private static final Integer HUNTER_STRENGTH = 40;
    private static final String HUNTER_BOOST_NAME = "Boost";
    private static final Integer HUNTER_BOOST_VALUE = 15;
    private static final String HUNTER_HEAL_NAME = "Heal";
    private static final Integer HUNTER_HEAL_VALUE = 20;

    /**
     * Create a new creature.
     *
     * @param creatureType The creature type.
     * @param name The creature name.
     *
     * @return The created creature.
     */
    public CreatureInterface createCreature(CreatureType creatureType, String name) {
        CreatureInterface creature;

        switch (creatureType) {
            case DRAGON:
                creature = this.createDragon(name);
                break;

            case HUNTER:
                creature = this.createHunter(name);
                break;

            default:
                creature = null;
        }

        return creature;
    }

    /**
     * Create a dragon creature.
     *
     * @param name The creature name.
     *
     * @return The dragon created.
     */
    private CreatureInterface createDragon(String name) {
        List<SkillInterface> skills = new ArrayList<>();

        skills.add(new Skill(
            CreatureFactory.DRAGON_FIREBALL_NAME,
            CreatureFactory.DRAGON_FIREBALL_VALUE,
            Caracteristic.CHANGE_LIFE
        ));
        skills.add(new Skill(
            CreatureFactory.DRAGON_HEAL_NAME,
            CreatureFactory.DRAGON_HEAL_VALUE,
            Caracteristic.CHANGE_LIFE
        ));

        return new Creature(
            name,
            CreatureFactory.DRAGON_HP,
            CreatureFactory.DRAGON_AP,
            CreatureFactory.DRAGON_STRENGTH,
            skills
        );
    }

    /**
     * Create a hunter creature.
     *
     * @param name The creature name.
     *
     * @return The hunter created.
     */
    private CreatureInterface createHunter(String name) {
        List<SkillInterface> skills = new ArrayList<>();

        skills.add(new Skill(
            CreatureFactory.HUNTER_BOOST_NAME,
            CreatureFactory.HUNTER_BOOST_VALUE,
            Caracteristic.CHANGE_ARMOR
        ));
        skills.add(new Skill(
            CreatureFactory.HUNTER_HEAL_NAME,
            CreatureFactory.HUNTER_HEAL_VALUE,
            Caracteristic.CHANGE_LIFE
        ));

        return new Creature(
            name,
            CreatureFactory.HUNTER_HP,
            CreatureFactory.HUNTER_AP,
            CreatureFactory.HUNTER_STRENGTH,
            skills
        );
    }
}
