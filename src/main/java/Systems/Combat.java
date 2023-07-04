package Systems;

import Abilities.Enemies.VoidImp.DarkBlast;
import Characters.Character;
import Abilities.Ability;
import Characters.Enemies.Enemy;
import Characters.Player;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    public static void startCombat(Player player, Enemy enemy) {
        System.out.println();
        System.out.println("A battle begins between " + player.getName() + " and " + enemy.getName() + "!");
        System.out.println();
        player.displayCharacterStats();
        enemy.displayCharacterStats();
        while (player.isAlive() && enemy.isAlive()) {
            // Player's turn
            System.out.println(player.getName() + "'s turn:");
            System.out.println();
            System.out.println(player.getName() + ": " + player.getHealth() + " HP");
            System.out.println(enemy.getName() + ": " + enemy.getHealth() + " HP");
            System.out.println();
            selectAndUseAbility(player, enemy);

            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " has been defeated. " + player.getName() + " wins!");
                player.gainExperience(enemy.getXpYield());
                int droppedGold = enemy.dropGold();
                player.addGold(droppedGold);
                System.out.println("You have gained " + droppedGold + " gold!");
                System.out.println("You now have " + player.getGold() + " gold.");
                System.out.println();
                break;
            }

            // Enemy's turn
            System.out.println(enemy.getName() + "'s turn:");
//            selectAndUseAbility(enemy, player);
            npcUseAbility(enemy, player);
            if (!player.isAlive()) {
                System.out.println(player.getName() + " has been defeated. " + enemy.getName() + " wins!");
                System.out.println();
                break;
            }
        }

        System.out.println("The battle has ended.");
        if(enemy.getEnemyTags().contains("Boss")){
            System.out.println("Congratulations! You have defeated this floor's boss and cleared the floor!");
        }
    }

    private static void selectAndUseAbility(Character player, Character target) {
        // Display available abilities to the user
        System.out.println("Available abilities:");
        for (int i = 0; i < player.getAbilities().size(); i++) {
            Ability currentAbility = player.getAbilities().get(i);
            if(currentAbility.getLevelRequirement() <= player.getLevel()) {
                System.out.println((i + 1) + ": " + currentAbility.getName() + " - " + currentAbility.getDescription());
            }
        }


        // Prompt the player to select an ability
        System.out.println();
        System.out.print("Select an ability by entering its number: ");
        System.out.println();
        int abilityIndex = getPlayerChoice(player.getAbilities().size());

        // Use the selected ability on the target
        Ability selectedAbility = player.getAbilities().get(abilityIndex);

        if(selectedAbility.isAoe()){

            for(Character enemy : CharacterManager.getEnemies()){
                selectedAbility.useAbility(player, enemy);
            }
            System.out.println("All enemies were hit by " + selectedAbility.getName());
        }
        else{
            selectedAbility.useAbility(player, target);
        }

        System.out.println();
    }

    private static void npcUseAbility(Character npc, Character target){
        List<Ability> abilities = npc.getAbilities();

        if (abilities.isEmpty()) {
            System.out.println(npc.getName() + " has no available abilities.");
            return;
        }

        Random random = new Random();
        Ability randomAbility = null;
        boolean validAbility = false;
        // Check to make sure that a npc only uses an ability that they're the proper level to use
        while(!validAbility) {
            int randomIndex = random.nextInt(abilities.size());
            randomAbility = abilities.get(randomIndex);
            if(randomAbility.getLevelRequirement() <= npc.getLevel()){
                validAbility = true;
            }
        }
        randomAbility.useAbility(npc, target);
        System.out.println(npc.getName() + " uses " + randomAbility.getName() + " on " + target.getName() + ", dealing" + randomAbility.getDamage() + " damage");
        System.out.println();
    }

    private static int getPlayerChoice(int maxChoice) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > maxChoice) {
                    System.out.print("Invalid choice. Please enter a number between 1 and " + maxChoice + ": ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1 and " + maxChoice + ": ");
            }
        }

        return choice - 1;
    }



}
