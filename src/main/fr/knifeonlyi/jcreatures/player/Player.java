package fr.knifeonlyi.jcreatures.player;

import fr.knifeonlyi.jcreatures.action.player.ActionPlayerInterface;
import fr.knifeonlyi.jcreatures.action.player.ConsoleAction;
import fr.knifeonlyi.jcreatures.action.player.RandomAction;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represent a player.
 */
public final class Player implements PlayerInterface {

    private static final String PLAYER_ACTIONS_ATTACK = "Attaquer";
    private static final String PLAYER_ACTIONS_ESCAPE = "S'enfuir";
    private static final String CREATURE_ACTIONS_BASE_ATTACK = "Attaque de base";
    private static final String CREATURE_ACTIONS_SKILL_ATTACK = "Compétence spéciale";

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

    @Override
    public List<CreatureInterface> getAliveCreatures() {
        List<CreatureInterface> aliveCreatures = new ArrayList<>();

        for (CreatureInterface creature : this.creatures) {
            if (creature.isAlive()) {
                aliveCreatures.add(creature);
            }
        }

        return aliveCreatures;
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

    @Override
    public Boolean attack(PlayerInterface target) throws InterruptedException {
        Integer actionPlayerChoice;
        Integer creaturePlayerChoice;

        String[] playerActions = {PLAYER_ACTIONS_ATTACK, PLAYER_ACTIONS_ESCAPE};
        String[] creatureActions = {CREATURE_ACTIONS_BASE_ATTACK, CREATURE_ACTIONS_SKILL_ATTACK};

        CreatureInterface engagedCreature;
        CreatureInterface targetCreature;
        SkillInterface engagedSkill;

        if (!target.hasAliveCreatures()) {
            System.out.println(String.format("FIN DU COMBAT (%s n'a plus de créatures en vie.)", this.getName()));

            return false;
        } else {
            actionPlayerChoice = this.actionPlayer.choiceAction(
                "Choisissez une action : ",
                Arrays.asList(playerActions)
            );

            if (PLAYER_ACTIONS_ESCAPE.equals(playerActions[actionPlayerChoice])) {
                return false;
            }

            engagedCreature = this.actionPlayer.choiceCreature("Choisissez la créature à engager.", this.creatures);

            targetCreature = this.actionPlayer.choiceCreature(
                "Choisissez la créature à attaquer.",
                target.getCreatures()
            );

            creaturePlayerChoice = this.actionPlayer.choiceAction(
                "Choisissez une action de créature",
                Arrays.asList(creatureActions)
            );

            if (CREATURE_ACTIONS_BASE_ATTACK.equals(creatureActions[creaturePlayerChoice])) {
                engagedCreature.attack(targetCreature);
                System.out.println(String.format(
                    "%s attaque %s avec une attaque de base (-%s pv)",
                    engagedCreature.getName(),
                    targetCreature.getName(),
                    engagedCreature.getStrength()
                ));
            } else {
                engagedSkill = this.actionPlayer.choiceSkill(
                    "Choisissez la compétence à utiliser.",
                    engagedCreature.getSkills()
                );

                engagedSkill.execute(engagedCreature, targetCreature);
            }
        }

        return true;
    }

    @Override
    public Boolean hasAliveCreatures() {
        boolean hasAliveCreatures = false;
        boolean continueSearch = true;
        Integer nbCreatures = this.getCreatures().size();
        Integer i = 0;

        while (continueSearch && (i < nbCreatures)) {
            if (this.getCreatures().get(i).isAlive()) {
                continueSearch = false;
                hasAliveCreatures = true;
            }

            i++;
        }

        return hasAliveCreatures;
    }
}
