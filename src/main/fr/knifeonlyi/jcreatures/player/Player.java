package fr.knifeonlyi.jcreatures.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a player.
 */
public final class Player implements PlayerInterface {

    private String name;
    private List<CreatureInterface> creatures;

    /**
     * Initialize a new player.
     *
     * @param name The name.
     */
    private Player(String name) {
        this.name = name;
        this.creatures = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<CreatureInterface> getCreatures() {
        return new ArrayList<>(this.creatures);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCreatures(List<CreatureInterface> creatures) {
        this.creatures = new ArrayList<>(creatures);
    }
}
