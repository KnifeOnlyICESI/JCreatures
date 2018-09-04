package fr.knifeonlyi.jcreatures;

import fr.knifeonlyi.jcreatures.creature.CreatureFactory;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.creature.CreatureType;
import fr.knifeonlyi.jcreatures.fight.arena.Duel;
import fr.knifeonlyi.jcreatures.player.Player;
import fr.knifeonlyi.jcreatures.player.PlayerInterface;
import fr.knifeonlyi.jcreatures.player.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final CreatureFactory CREATURE_FACTORY = new CreatureFactory();

    public static void main(String[] args) {
        PlayerInterface player1 = new Player("Dany", PlayerType.HUMAN);
        PlayerInterface player2 = new Player("AI", PlayerType.PNJ);

        List<CreatureInterface> creaturesPlayer1 = new ArrayList<>();
        List<CreatureInterface> creaturesPlayer2 = new ArrayList<>();

        Duel duel = new Duel(player1, player2);

        creaturesPlayer1.add(CREATURE_FACTORY.createCreature(CreatureType.DRAGON, "Dragon"));
        creaturesPlayer2.add(CREATURE_FACTORY.createCreature(CreatureType.HUNTER, "Hunter"));

        player1.setCreatures(creaturesPlayer1);
        player2.setCreatures(creaturesPlayer2);

        duel.fight();
    }
}
