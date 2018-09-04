package fr.knifeonlyi.jcreatures;

import fr.knifeonlyi.jcreatures.action.player.ActionPlayerInterface;
import fr.knifeonlyi.jcreatures.action.player.ConsoleAction;
import fr.knifeonlyi.jcreatures.action.player.RandomAction;
import fr.knifeonlyi.jcreatures.creature.CreatureFactory;
import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.creature.CreatureType;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static ActionPlayerInterface console = new ConsoleAction();
    private static ActionPlayerInterface random = new RandomAction();
    private static CreatureFactory creatureFactory = new CreatureFactory();

    public static void main(String[] args) {
        try {
            testAllChoices();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void testAllChoices() throws InterruptedException {
        List<String> actions = new ArrayList<>();
        List<CreatureInterface> creatures = new ArrayList<>();

        CreatureInterface choosenCreature;
        SkillInterface choosenSkill;
        String choosenAction;

        actions.add("Attack");
        actions.add("Defense");

        creatures.add(creatureFactory.createCreature(CreatureType.DRAGON, "Dragon ultim"));
        creatures.add(creatureFactory.createCreature(CreatureType.HUNTER, "Hunter ultim"));
        creatures.add(creatureFactory.createCreature(CreatureType.DRAGON, "Dragon"));
        creatures.add(creatureFactory.createCreature(CreatureType.HUNTER, "Hunter"));

        choosenCreature = console.choiceCreature(creatures);
        choosenSkill = console.choiceSkill(choosenCreature.getSkills());
        choosenAction = actions.get(console.choiceAction(actions));

        System.out.println(
            String.format(
                "Action : %s%nCreature : %s%nSkill : %s",
                choosenAction,
                choosenCreature.getName(),
                choosenSkill.getName()
            )
        );

        choosenCreature = random.choiceCreature(creatures);
        choosenSkill = random.choiceSkill(choosenCreature.getSkills());
        choosenAction = actions.get(random.choiceAction(actions));

        System.out.println("=========================================");
        System.out.println();

        System.out.println(
            String.format(
                "Action : %s%nCreature : %s%nSkill : %s",
                choosenAction,
                choosenCreature.getName(),
                choosenSkill.getName()
            )
        );
    }
}
