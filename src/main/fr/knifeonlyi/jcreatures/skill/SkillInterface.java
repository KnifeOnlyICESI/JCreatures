package fr.knifeonlyi.jcreatures.skill;

import fr.knifeonlyi.choicelib.Choosable;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

/**
 * The base interface for all interfaces.
 */
public interface SkillInterface extends Choosable {

    /**
     * Get the name.
     *
     * @return The name.
     */
    String getName();

    /**
     * Get the value.
     *
     * @return The new value.
     */
    Integer getValue();

    /**
     * Get the caracteristic.
     *
     * @return The caracteristic.
     */
    Caracteristic getCaracteristic();

    /**
     * Set the name.
     *
     * @param name The new name.
     */
    void setName(String name);

    /**
     * Set the value.
     *
     * @param value The new value.
     */
    void setValue(Integer value);

    /**
     * Set the caracteristic.
     *
     * @param caracteristic The new caracteristic.
     */
    void setCaracteristic(Caracteristic caracteristic);

    /**
     * Execute the skill.
     *
     * @param summoner The summoner.
     * @param target   The target.
     */
    void execute(CreatureInterface summoner, CreatureInterface target);
}
