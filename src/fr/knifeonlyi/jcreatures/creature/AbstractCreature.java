package fr.knifeonlyi.jcreatures.creature;

/**
 * The base class for all creatures.
 */
public abstract class AbstractCreature implements CreatureInterface {

    private String name;
    private Integer hp;
    private Integer ap;

    /**
     * Initialize a new creature.
     *
     * @param name The name.
     * @param hp   The health points.
     * @param ap   The armor points.
     */
    public AbstractCreature(String name, Integer hp, Integer ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    @Override
    public final String getName() {
        return this.name;
    }

    @Override
    public Integer getHP() {
        return this.hp;
    }

    @Override
    public Integer getAP() {
        return this.ap;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHP(Integer hp) {
        this.hp = hp;
    }

    @Override
    public void setAP(Integer ap) {
        this.ap = ap;
    }
}
