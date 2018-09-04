package fr.knifeonlyi.jcreatures.player;

import fr.knifeonlyi.choicelib.Action;
import fr.knifeonlyi.choicelib.Choice;
import fr.knifeonlyi.choicelib.ConsoleChoice;
import fr.knifeonlyi.choicelib.RandomChoice;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private Choice chooser;

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
            this.chooser = new RandomChoice(new SecureRandom());
        } else {
            this.chooser = new ConsoleChoice(new Scanner(System.in));
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
    public Boolean attack(PlayerInterface target) {
        Action chooserChoice;
        Action creaturePlayerChoice;

        ArrayList<Action> playerActions = new ArrayList<>();
        ArrayList<Action> creatureActions = new ArrayList<>();

        playerActions.add(new Action(PLAYER_ACTIONS_ATTACK));
        playerActions.add(new Action(PLAYER_ACTIONS_ESCAPE));

        creatureActions.add(new Action(CREATURE_ACTIONS_BASE_ATTACK));
        creatureActions.add(new Action(CREATURE_ACTIONS_SKILL_ATTACK));

        CreatureInterface engagedCreature;
        CreatureInterface targetCreature;
        SkillInterface engagedSkill;

        if (!target.hasAliveCreatures()) {
            System.out.println(String.format("FIN DU COMBAT (%s n'a plus de créatures en vie.)", this.getName()));

            return false;
        } else {
            chooserChoice = (Action) this.chooser.choose(playerActions, "Choisissez une action : ");

            if (chooserChoice.getName().equals(PLAYER_ACTIONS_ESCAPE)) {
                System.out.println(String.format("FIN DU COMBAT (%s a fuit le combat.)", this.getName()));

                return false;
            }

            engagedCreature = (CreatureInterface) this.chooser.choose(
                this.creatures,
                "Choisissez la créature à engager : "
            );

            targetCreature = (CreatureInterface) this.chooser.choose(
                target.getCreatures(),
                "Choisissez la créature à attaquer : "
            );

            creaturePlayerChoice = (Action) this.chooser.choose(
                creatureActions,
                "Choisissez l'action que doit effectuer la créature engagé : "
            );

            if (creaturePlayerChoice.getName().equals(CREATURE_ACTIONS_BASE_ATTACK)) {
                engagedCreature.attack(targetCreature);
                System.out.println(String.format(
                    "%s attaque %s avec une attaque de base (-%s pv)",
                    engagedCreature.getName(),
                    targetCreature.getName(),
                    engagedCreature.getStrength()
                ));
            } else {
                engagedSkill = (SkillInterface) this.chooser.choose(
                    engagedCreature.getSkills(),
                    "Choisissez la compétence à utiliser."
                );

                engagedSkill.execute(engagedCreature, targetCreature);
            }
        }

        System.out.println(
            String.format(
                "Status créature attaquée : %s [%s pv] [%s pa]",
                targetCreature.getName(),
                targetCreature.getHP(),
                targetCreature.getAP()
            ));

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
