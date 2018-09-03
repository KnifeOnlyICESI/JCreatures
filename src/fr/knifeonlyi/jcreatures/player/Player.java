package fr.knifeonlyi.jcreatures.player;

/**
 * Represent a player.
 */
public class Player implements PlayerInterface {

    private static Player selfInstance;

    private String name;

    /**
     * Initialize a new player.
     *
     * @param name The name.
     */
    private Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get an instance of player.
     *
     * @param name The name.
     * @return The unique instance of player (Singleton pattern).
     */
    public static Player getInstance(String name) {
        if (selfInstance == null) {
            selfInstance = new Player(name);
        }

        return selfInstance;
    }
}
