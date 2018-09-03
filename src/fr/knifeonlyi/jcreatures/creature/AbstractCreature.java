package fr.knifeonlyi.jcreatures.creature;

import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class for all creatures.
 */
public abstract class AbstractCreature implements CreatureInterface {

    private String name;
    private Integer healthPoints;
    private Integer armorPoints;
    private Integer strength;
    private List<SkillInterface> skills;

    /**
     * Initialize a new creature.
     *
     * @param name         The name.
     * @param healthPoints The health points.
     * @param armorPoints  The armor points.
     * @param strength     The strength.
     * @param skills       The skills.
     */
    public AbstractCreature(
        String name,
        Integer healthPoints,
        Integer armorPoints,
        Integer strength,
        List<SkillInterface> skills
    ) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.armorPoints = armorPoints;
        this.strength = strength;
        this.skills = new ArrayList<>(skills);

        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }

        if (this.armorPoints < 0) {
            this.armorPoints = 0;
        }
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public Integer getHP() {
        return this.healthPoints;
    }

    @Override
    public Integer getAP() {
        return this.armorPoints;
    }

    @Override
    public Integer getStrength() {
        return this.strength;
    }

    @Override
    public List<SkillInterface> getSkills() {
        return new ArrayList<>(this.skills);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHP(Integer healthPoints) {
        this.healthPoints = healthPoints;

        if (this.healthPoints < 0) {
            this.healthPoints = 0;
        }
    }

    @Override
    public void setAP(Integer armorPoints) {
        this.armorPoints = armorPoints;

        if (this.armorPoints < 0) {
            this.armorPoints = 0;
        }
    }

    @Override
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public void setSkills(List<SkillInterface> skills) {
        this.skills = new ArrayList<>(skills);
    }

    @Override
    public void attack(CreatureInterface target) {
        target.setHP(target.getHP() - this.strength);
    }

    /**
     * Check if the creature is alive.
     *
     * @return TRUE if creature is alive. FALSE otherwise.
     */
    public Boolean isAlive() {
        return (this.healthPoints > 0);
    }
}
