package Systems;

import Characters.Character;
import Abilities.Ability;

public class Combat {
    public static void startCombat(Character player, Character enemy) {
        System.out.println("A battle begins between " + player.getName() + " and " + enemy.getName() + "!");

        while (player.isAlive() && enemy.isAlive()) {
            // Player's turn
            System.out.println(player.getName() + "'s turn:");
            displayCharacterStats(player);
            displayCharacterStats(enemy);
            selectAndUseAbility(player, enemy);

            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " has been defeated. " + player.getName() + " wins!");
                break;
            }

            // Enemy's turn
            System.out.println(enemy.getName() + "'s turn:");
            selectAndUseAbility(enemy, player);

            if (!player.isAlive()) {
                System.out.println(player.getName() + " has been defeated. " + enemy.getName() + " wins!");
                break;
            }
        }

        System.out.println("The battle has ended.");
    }

    private static void displayCharacterStats(Character character) {
        System.out.println(character.getName() + ":");
        System.out.println("Health: " + character.getHealth());
        System.out.println("Magic: " + character.getMagic());
        System.out.println("Strength: " + character.getStrength());
        System.out.println("Defense: " + character.getDefense());
        System.out.println();
    }

    private static void selectAndUseAbility(Character player, Character target) {
        // Display available abilities to the user
        System.out.println("Available abilities:");
        for (Ability ability : user.getAbilities()) {
            System.out.println(ability.getName() + " - " + ability.getDescription());
        }

        // Select an ability to use
        Ability selectedAbility = // Get the selected ability from user input or other means

                // Use the selected ability
                selectedAbility.useAbility(user, target);
    }
}
