package fr.knifeonlyi.jcreatures.creature;

import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.List;

public class Creature extends AbstractCreature {

    /**
     * Initialize a new creature.
     *
     * @param name         The name.
     * @param healthPoints The health points.
     * @param armorPoints  The armor points.
     * @param strength     The strength.
     * @param skills       The skills.
     */
    public Creature(
        String name,
        Integer healthPoints,
        Integer armorPoints,
        Integer strength,
        List<SkillInterface> skills
    ) {
        super(name, healthPoints, armorPoints, strength, skills);
    }
}
