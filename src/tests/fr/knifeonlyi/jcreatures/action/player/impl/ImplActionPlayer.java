package fr.knifeonlyi.jcreatures.action.player.impl;

import fr.knifeonlyi.jcreatures.action.player.ActionPlayerInterface;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.List;

public class ImplActionPlayer implements ActionPlayerInterface {

    @Override
    public SkillInterface choiceSkill(String message, List<SkillInterface> skills) throws InterruptedException {
        return skills.get(0);
    }

    @Override
    public CreatureInterface choiceCreature(String message, List<CreatureInterface> creatures) throws
        InterruptedException {
        return creatures.get(0);
    }

    @Override
    public Integer choiceAction(String message, List<String> actions) throws InterruptedException {
        return 0;
    }
}
