package fr.knifeonlyi.jcreatures.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

import java.util.List;

/**
 * The base interface for all players.
 */
public interface PlayerInterface {

    /**
     * Get the name.
     *
     * @return The name.
     */
    String getName();

    /**
     * Get the creatures.
     *
     * @return The creatures.
     */
    List<CreatureInterface> getCreatures();

    /**
     * Set the name.
     *
     * @param name The new name.
     */
    void setName(String name);

    /**
     * Set the creatures.
     *
     * @param creatures The new creatures.
     */
    void setCreatures(List<CreatureInterface> creatures);
}
