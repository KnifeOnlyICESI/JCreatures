package fr.knifeonlyi.jcreatures.creature;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatureFactoryTest {

    private static final String DRAGON_NAME = "Dragon";
    private static final String HUNTER_NAME = "Hunter";

    private CreatureFactory creatureFactory;

    @Before
    public void setUp() {
        this.creatureFactory = new CreatureFactory();
    }

    @Test
    public void testCreateCreatureDragon() {
        CreatureInterface dragon = this.creatureFactory.createCreature(CreatureType.DRAGON, CreatureFactoryTest.DRAGON_NAME);

        assertEquals(CreatureFactoryTest.DRAGON_NAME, dragon.getName());
    }

    @Test
    public void testCreateCreatureHunter() {
        CreatureInterface dragon = this.creatureFactory.createCreature(CreatureType.HUNTER, CreatureFactoryTest.HUNTER_NAME);

        assertEquals(CreatureFactoryTest.HUNTER_NAME, dragon.getName());
    }
}
