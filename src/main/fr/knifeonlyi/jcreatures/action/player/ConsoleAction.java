package fr.knifeonlyi.jcreatures.action.player;

import fr.knifeonlyi.jcreatures.creature.CreatureInterface;
import fr.knifeonlyi.jcreatures.skill.SkillInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * The class to manipulate player action into the console.
 */
public class ConsoleAction implements ActionPlayerInterface {

    private static final Integer TIME_TO_SLEEP = 500;
    private static final String PROMPT = ">>>";

    private Scanner scanner = new Scanner(System.in);

    @Override
    public SkillInterface choiceSkill(String message, List<SkillInterface> skills) throws InterruptedException {
        List<String> skillsName = new ArrayList<>();
        int userChoice;

        for (SkillInterface skill : skills) {
            skillsName.add(skill.getName());
        }

        // While the user input is not valid.
        do {
            displayItemsMenu("Skills", message, skillsName);

            userChoice = this.scanner.nextInt();
        } while (!checkInput(userChoice, skillsName.size()));

        return skills.get((userChoice - 1));
    }

    @Override
    public CreatureInterface choiceCreature(String message, List<CreatureInterface> creatures) throws
        InterruptedException {
        List<String> creaturesName = new ArrayList<>();
        int userChoice;

        for (CreatureInterface creature : creatures) {
            creaturesName.add(creature.getName());
        }

        // While the user input is not valid.
        do {
            displayItemsMenu("Creatures", message, creaturesName);

            userChoice = this.scanner.nextInt();
        } while (!checkInput(userChoice, creaturesName.size()));

        return creatures.get((userChoice - 1));
    }

    @Override
    public Integer choiceAction(String message, List<String> actions) throws InterruptedException {
        int userChoice;

        // While the user input is not valid.
        do {
            displayItemsMenu("Actions", message, actions);

            userChoice = this.scanner.nextInt();
        } while (!checkInput(userChoice, actions.size()));

        return (userChoice - 1);
    }

    /**
     * Check if specified input value is valid. (Minimum value is always equals to 1)
     *
     * @param input The input value.
     * @param max   The maximum value.
     * @return TRUE if the specified input value is valid. FALSE otherwise.
     * @throws InterruptedException If the time thread failed.
     */
    private static Boolean checkInput(Integer input, Integer max) throws InterruptedException {
        Boolean inputIsValid = ((input <= max) && (input > 0));

        if (!inputIsValid) {
            System.err.println(
                String.format("INVALID CHOICE : Please choose a number between %s and %s.%n", 1, max)
            );

            TimeUnit.MILLISECONDS.sleep(TIME_TO_SLEEP);
        }

        return inputIsValid;
    }

    /**
     * Display the actions choice menu.
     *
     * @param name    The menu name to display.
     * @param message The message to display.
     * @param items   The items list (to string format).
     */
    private static void displayItemsMenu(String name, String message, List<String> items) {
        Integer nbActions = items.size();

        System.out.println(String.format("============== %s Menu ==============", name));

        for (Integer i = 0; i < nbActions; i++) {
            System.out.println(String.format("%s. %s", (i + 1), items.get(i)));
        }

        System.out.println("=========================================");
        System.out.println(message);
        System.out.print(String.format("%s ", ConsoleAction.PROMPT));
    }
}
