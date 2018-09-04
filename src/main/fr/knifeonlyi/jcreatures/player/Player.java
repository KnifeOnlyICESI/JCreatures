package fr.knifeonlyi.jcreatures.player;

import fr.knifeonlyi.jcreatures.action.player.ActionPlayerInterface;
import fr.knifeonlyi.jcreatures.action.player.ConsoleAction;
import fr.knifeonlyi.jcreatures.action.player.RandomAction;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent a player.
 */
public final class Player implements PlayerInterface {

    private String name;
    private List<CreatureInterface> creatures;
    private PlayerType type;
    private ActionPlayerInterface actionPlayer;

    /**
     * Initialize a new player.
     *
     * @param name The name.
     */
    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.creatures = new ArrayList<>();
        this.type = playerType;

        if (this.type == PlayerType.PNJ) {
            this.actionPlayer = new RandomAction();
        } else {
            this.actionPlayer = new ConsoleAction();
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<CreatureInterface> getCreatures() {
        return new ArrayList<>(this.creatures);
    }

    public PlayerType getType() {
        return this.type;
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
