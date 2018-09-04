package fr.knifeonlyi.jcreatures.action.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.security.SecureRandom;
import java.util.List;

/**
 * The class to manipulate the action player by random.
 */
public class RandomAction implements ActionPlayerInterface {

    private static SecureRandom random = new SecureRandom();

    @Override
    public SkillInterface choiceSkill(List<SkillInterface> skills) {
        return skills.get(random.nextInt(skills.size()));
    }

    @Override
    public CreatureInterface choiceCreature(List<CreatureInterface> creatures) {
        return creatures.get(random.nextInt(creatures.size()));
    }

    @Override
    public Integer choiceAction(List<String> actions) {
        return random.nextInt(actions.size());
    }
}
