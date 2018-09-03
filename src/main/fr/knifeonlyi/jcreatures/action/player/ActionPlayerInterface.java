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
     * @param skills The skills.
     * @return The choosen skill.
     */
    SkillInterface choiceSkill(List<SkillInterface> skills);

    /**
     * Choice a creature into the specified creatures and return the choice.
     *
     * @param creatures The creatures.
     * @return The choosen creatures.
     */
    CreatureInterface choiceCreature(List<CreatureInterface> creatures);

    /**
     * Choice an action into the specified actions and return the choice.
     *
     * @param actions The actions.
     * @return The choosen action.
     */
    Integer choiceAction(List<String> actions);
}
