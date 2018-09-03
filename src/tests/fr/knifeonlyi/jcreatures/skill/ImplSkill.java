package fr.knifeonlyi.jcreatures.skill;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

public class ImplSkill extends AbstractSkill {

    public ImplSkill(String name, Integer value, Caracteristic caracteristic) {
        super(name, value, caracteristic);
    }

    @Override
    public void execute(
        CreatureInterface summoner, CreatureInterface target
    ) {}
}
