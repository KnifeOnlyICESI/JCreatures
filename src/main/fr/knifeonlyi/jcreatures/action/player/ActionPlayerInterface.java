package fr.knifeonlyi.jcreatures.action.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.List;

/**
 * The base interface for all actions.
 */
public interface ActionPlayerInterface {

    /**
     * Choice a skill into the specified skills and return the choice.
     *
     * @param message The message to print.
     * @param skills  The skills.
     * @return The choosen skill.
     */
    SkillInterface choiceSkill(String message, List<SkillInterface> skills) throws InterruptedException;

    /**
     * Choice a creature into the specified creatures and return the choice.
     *
     * @param message   The message to print.
     * @param creatures The creatures.
     * @return The choosen creatures.
     */
    CreatureInterface choiceCreature(String message, List<CreatureInterface> creatures) throws InterruptedException;

    /**
     * Choice an action into the specified actions and return the choice.
     *
     * @param message The message to print.
     * @param actions The actions.
     * @return The choosen action.
     */
    Integer choiceAction(String message, List<String> actions) throws InterruptedException;
}
