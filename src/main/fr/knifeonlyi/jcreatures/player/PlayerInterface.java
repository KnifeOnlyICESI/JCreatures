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
     * Get the alive creatures.
     *
     * @return The alive creatures.
     */
    List<CreatureInterface> getAliveCreatures();

    /**
     * Get the type.
     *
     * @return The type.
     */
    PlayerType getType();

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

    /**
     * Attack an other player.
     *
     * @param target An other player to attack.
     * @return TRUE if the player can be attack. FALSE otherwise.
     */
    Boolean attack(PlayerInterface target);

    /**
     * Check if the player have alive creatures.
     *
     * @return TRUE if the player have alive creatures. FALSE otherwise.
     */
    Boolean hasAliveCreatures();
}
