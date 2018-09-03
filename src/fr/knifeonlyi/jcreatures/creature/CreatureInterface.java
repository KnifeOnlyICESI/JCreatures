package fr.knifeonlyi.jcreatures.creature;

/**
 * The base interface for all creatures.
 */
public interface CreatureInterface {

    /**
     * Get the name.
     *
     * @return The name.
     */
    String getName();

    /**
     * Get the health points.
     *
     * @return The health points.
     */
    Integer getHP();

    /**
     * Get the armor points.
     *
     * @return The armor points.
     */
    Integer getAP();

    /**
     * Set the name.
     *
     * @param name The new name.
     */
    void setName(String name);

    /**
     * Set the health points.
     *
     * @param hp The new health points.
     */
    void setHP(Integer hp);

    /**
     * Set the armor points.
     *
     * @param ap The new armor points.
     */
    void setAP(Integer ap);
}
