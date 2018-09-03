package fr.knifeonlyi.jcreatures.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private static final String NAME = "Dany";

    private Player player;

    @Before
    public void setUp() {
        player = Player.getInstance(PlayerTest.NAME);
    }

    @Test
    public void testSetName() {
        assertEquals(PlayerTest.NAME, this.player.getName());
    }

    @Test
    public void testSetCreatures() {
        assertEquals(0, this.player.getCreatures().size());
    }
}
