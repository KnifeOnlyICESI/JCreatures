package fr.knifeonlyi.jcreatures;

import fr.knifeonlyi.jcreatures.creature.CreatureFactory;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.creature.CreatureType;
import fr.knifeonlyi.jcreatures.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger("");
    private static CreatureFactory creatureFactory = new CreatureFactory();
    private static Player player = Player.getInstance("Dany");

    public static void main(String[] args) {
        List<CreatureInterface> creatures = new ArrayList<>();
        String nbCreatures;

        creatures.add(creatureFactory.createCreature(CreatureType.DRAGON, "Dragon"));
        creatures.add(creatureFactory.createCreature(CreatureType.HUNTER, "Hunter"));

        player.setCreatures(creatures);

        nbCreatures = Integer.toString(player.getCreatures().size());

        logger.log(Level.INFO, player.getName());
        logger.log(Level.INFO, nbCreatures);
    }
}
