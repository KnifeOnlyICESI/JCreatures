package fr.knifeonlyi.jcreatures;

import fr.knifeonlyi.jcreatures.player.Player;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("");
        Player player = Player.getInstance("Dany");

        logger.log(Level.INFO, player.getName());
    }
}
