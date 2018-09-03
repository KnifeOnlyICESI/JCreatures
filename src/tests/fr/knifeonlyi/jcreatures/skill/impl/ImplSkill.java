package fr.knifeonlyi.jcreatures.skill.impl;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.AbstractSkill;
import fr.knifeonlyi.jcreatures.skill.Caracteristic;

public class ImplSkill extends AbstractSkill {

    public ImplSkill(String name, Integer value, Caracteristic caracteristic) {
        super(name, value, caracteristic);
    }

    @Override
    public void execute(
        CreatureInterface summoner, CreatureInterface target
    ) {}
}
