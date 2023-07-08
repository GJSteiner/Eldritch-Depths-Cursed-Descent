package Systems;

import Abilities.Enemies.VoidImp.DarkBlast;
import Characters.Character;
import Abilities.Ability;
import Characters.Enemies.Enemy;
import Characters.Player;
import Items.Consumables.Potions.UsableItem;
import Items.Item;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static Systems.GameRunner.gameOver;

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
            System.out.println(player.getName() + "'s Health: " + player.getHealth() + " HP");
            if(enemy.getName().endsWith("s")){
                System.out.println(enemy.getName() + "' Health: " + enemy.getHealth() + " HP");
            }
            else {
                System.out.println(enemy.getName() + "'s Health: " + enemy.getHealth() + " HP");
            }
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
                Item droppedItem = enemy.dropRandomItem();
                if(droppedItem != null) {
                    System.out.println(enemy.getName() + " dropped a " + droppedItem.getName() + "!");
                    System.out.println(player.getName() + " picked up a " + droppedItem.getName() + ".");
                    player.getInventory().add(droppedItem);
                }
                break;
            }

            // Enemy's turn
            System.out.println(enemy.getName() + "'s turn:");
            npcUseAbility(enemy, player);
            if (!player.isAlive()) {
                System.out.println(player.getName() + " has been defeated. " + enemy.getName() + " wins!");
                System.out.println();
                gameOver(player);
                break;
            }

            player.updateDamageOverTime();
            enemy.updateDamageOverTime();


            // Displaying dot damage for player
            for (DamageOverTime dot : player.getDamageOverTimeEffects()) {
                System.out.println(player.getName() + " takes " + dot.getDamagePerRound() + " damage from " + dot.getDotName() + ".");
            }

            // Displaying dot damage for enemy
            for (DamageOverTime dot : enemy.getDamageOverTimeEffects()) {
                System.out.println(enemy.getName() + " takes " + dot.getDamagePerRound() + " damage from " + dot.getDotName() + ".");
            }
            System.out.println();
        }

        System.out.println("The battle has ended.");
        if(enemy.getEnemyTags().contains("Boss")){
            System.out.println("Congratulations! You have defeated this floor's boss and cleared the floor!");
        }
        player.makeChoice();

    }

    private static void selectAndUseAbility(Character player, Character target) {
        // Displaying available abilities to the user
        System.out.println("Available abilities:");
        for (int i = 0; i < player.getAbilities().size(); i++) {
            Ability currentAbility = player.getAbilities().get(i);
            if(currentAbility.getLevelRequirement() <= player.getLevel()) {
                System.out.println((i + 1) + ": " + currentAbility.getName() + " - " + currentAbility.getDescription());
            }
        }

        // Displaying available consumables in the inventory
        System.out.println("Available consumables:");
        List<Item> inventory = player.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (currentItem instanceof UsableItem) {
                UsableItem usableItem = (UsableItem) currentItem;
                System.out.println((i + 1) + ": " + usableItem.getName() + " - " + usableItem.getDescription());
            }
        }


        // Prompting the player to select an action
        System.out.println();
        System.out.print("Select an ability or consumable by entering its number: ");
        System.out.println();
        int choice = getPlayerChoice(player.getAbilities().size() + inventory.size());

        // Use the selected ability on the target
        if(choice <= player.getAbilities().size()) {
            int abilityIndex = choice;

            Ability selectedAbility = player.getAbilities().get(abilityIndex);

            if (selectedAbility.isAoe()) {

                for (Character enemy : CharacterManager.getEnemies()) {
                    selectedAbility.useAbility(player, enemy);
                }
                System.out.println("All enemies were hit by " + selectedAbility.getName());
            } else {
                selectedAbility.useAbility(player, target);
            }
        }
        else{
            int itemIndex = choice - player.getInventory().size() - 1;
            Item selectedItem = inventory.get(itemIndex);
            if (selectedItem instanceof UsableItem) {
                UsableItem usableItem = (UsableItem) selectedItem;
                usableItem.use(player);
                System.out.println("You used " + usableItem.getName() + ".");
            }
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
