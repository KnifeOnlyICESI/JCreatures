package fr.knifeonlyi.jcreatures.skill;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

public class Skill extends AbstractSkill {

    public Skill(String name, Integer value, Caracteristic caracteristic) {
        super(name, value, caracteristic);
    }

    @Override
    public void execute(CreatureInterface summoner, CreatureInterface target) {
        if (this.getCaracteristic() == Caracteristic.CHANGE_LIFE) {
            target.setHP(target.getHP() + this.getValue());
        } else if (this.getCaracteristic() == Caracteristic.CHANGE_ARMOR) {
            target.setAP(target.getAP() + this.getValue());
        }
    }
}
