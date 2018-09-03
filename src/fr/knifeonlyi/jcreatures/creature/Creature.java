package fr.knifeonlyi.jcreatures.creature;

public class Creature extends AbstractCreature {

    /**
     * Initialize a new creature.
     *
     * @param name The name.
     * @param hp   The health points.
     * @param ap   The armor points.
     */
    public Creature(String name, Integer hp, Integer ap) {
        super(name, hp, ap);
    }
}
