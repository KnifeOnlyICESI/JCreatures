package fr.knifeonlyi.jcreatures.action.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.List;

public class Console implements ActionPlayerInterface {

    @Override
    public SkillInterface choiceSkill(List<SkillInterface> skills) {
        return null;
    }

    @Override
    public CreatureInterface choiceCreature(List<CreatureInterface> creatures) {
        return null;
    }

    @Override
    public Integer choiceAction(List<String> actions) {
        return null;
    }
}
