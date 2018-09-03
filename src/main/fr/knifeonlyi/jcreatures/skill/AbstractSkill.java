package fr.knifeonlyi.jcreatures.skill;

public abstract class AbstractSkill implements SkillInterface {

    private String name;
    private Integer value;
    private Caracteristic caracteristic;

    public AbstractSkill(String name, Integer value, Caracteristic caracteristic) {
        this.name = name;
        this.value = value;
        this.caracteristic = caracteristic;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public Caracteristic getCaracteristic() {
        return this.caracteristic;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void setCaracteristic(Caracteristic caracteristic) {
        this.caracteristic = caracteristic;
    }
}
