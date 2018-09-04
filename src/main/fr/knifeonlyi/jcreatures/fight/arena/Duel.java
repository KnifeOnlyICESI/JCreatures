package fr.knifeonlyi.jcreatures.fight.arena;

import fr.knifeonlyi.jcreatures.player.PlayerInterface;

/**
 * Represent the class to make a duel with 2 players.
 */
public class Duel {

    private static final Integer EVEN_CHECKER = 2;

    private PlayerInterface player1;
    private PlayerInterface player2;
    private Integer turnsCount;

    /**
     * Initialize the duel.
     *
     * @param player1 The player 1.
     * @param player2 The player 2.
     */
    public Duel(PlayerInterface player1, PlayerInterface player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.turnsCount = 1;
    }

    /**
     * Execute the fight between the two players.
     */
    public void fight() {
        // While the two players have creatures and turn doesn't exit on an end fight.
        while (this.player1.hasAliveCreatures() && this.player2.hasAliveCreatures() && this.executeOneTurn()) {
            this.turnsCount++;
        }
    }

    /**
     * Execute one turn of the fight.
     *
     * @return TRUE if the turn has no problem or ending phase. FALSE otherwise.
     */
    private Boolean executeOneTurn() {
        if ((this.turnsCount % EVEN_CHECKER) != 0) {
            System.out.println("EVEN");

            if (this.player1.attack(this.player2)) {
                return this.player2.attack(player1);
            } else {
                return false;
            }
        } else {
            System.out.println("NOT EVEN");

            if (this.player2.attack(this.player1)) {
                return this.player1.attack(player2);
            } else {
                return false;
            }
        }
    }
}
