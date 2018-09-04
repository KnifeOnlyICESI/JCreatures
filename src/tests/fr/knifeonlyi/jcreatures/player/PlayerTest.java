package fr.knifeonlyi.jcreatures.player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private static final String NAME = "Dany";
    private static final PlayerType TYPE = PlayerType.HUMAN;

    private Player player;

    @Before
    public void setUp() {
        player = new Player(NAME, TYPE);
    }

    @Test
    public void testSetName() {
        assertEquals(
            String.format("Should be equals to %s.", NAME),
            NAME,
            this.player.getName()
        );
    }

    @Test
    public void testSetCreatures() {
        assertEquals("Should be equals to 0.", 0, this.player.getCreatures().size());
    }

    @Test
    public void testGetType() {
        assertEquals(
            String.format("Should be equals to %s.", TYPE),
            TYPE,
            this.player.getType()
        );
    }
}
