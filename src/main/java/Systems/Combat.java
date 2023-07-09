package Systems;

import Characters.Character;
import Abilities.Ability;
import Characters.Enemies.Enemy;
import Characters.Player;
import Items.Consumables.UsableItem;
import Items.Item;

import java.util.List;
import java.util.Random;

import static Systems.GameRunner.gameOver;
import static Systems.GameRunner.getPlayerChoice;

public class Combat {
    public static void startCombat(Player player, List<Enemy> aliveEnemies) {
        boolean bossEnemyRoom = false;
        if(aliveEnemies.size() == 1){
            System.out.println();
            System.out.println("A battle begins between " + player.getName() + " and " + aliveEnemies.get(0).getName() + "!");
            System.out.println();
        }
        else{
            System.out.println();
            System.out.println("A battle begins between " + player.getName() + " and multiple enemies!");
            System.out.println();

        }
        for (int i = 0; i < aliveEnemies.size(); i++) {
            aliveEnemies.get(i).displayCharacterStats();
            if(aliveEnemies.get(i).getEnemyTags().contains("Boss")){
                bossEnemyRoom = true;
            }
        }
        System.out.println();
        player.displayCharacterStats();

        for (int i = 0; i < aliveEnemies.size(); i++) {
            Enemy enemy = aliveEnemies.get(i);
            System.out.println("Enemy Number " + i);
            enemy.displayCharacterStats();
            System.out.println();
            while (player.isAlive() && enemy.isAlive()) {
                // Player's turn
                System.out.println(player.getName() + "'s turn:");
                System.out.println();
                System.out.println(player.getName() + "'s Health: " + player.getHealth() + " HP");
                System.out.println(enemy.getName() + "'s Health: " + enemy.getHealth() + " HP");
                System.out.println();
                chooseActionOrItem(player, enemy);

                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " has been defeated. " + player.getName() + " wins!");
                    player.gainExperience(enemy.getXpYield());
                    int droppedGold = enemy.dropGold();
                    player.addGold(droppedGold);
                    System.out.println("You have gained " + droppedGold + " gold!");
                    System.out.println("You now have " + player.getGold() + " gold.");
                    System.out.println();
                    Item droppedItem = enemy.dropRandomItem();
                    if (droppedItem != null) {
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
        }
        if (bossEnemyRoom) {
            System.out.println("Congratulations! You have defeated this floor's boss and cleared the floor!");
        }
        else if(aliveEnemies.size() == 1){
            System.out.println("The battle against " + aliveEnemies.get(0).getName() + " has ended.");
        }
        else{
            System.out.println("The battle has ended.");
        }

        player.makeChoice();

    }
    private static int chooseActionOrItem(Character player, Character target){
        int choice = 0;
            System.out.println("1. Attack");
            System.out.println("2. Use Item");
            System.out.println("3. Check Stats");
            choice = getPlayerChoice(3)+1;

        switch(choice){
            case 1:
                selectAndUseAbility(player, target);
                break;
            case 2:
                selectAndUseItem(player, target);
                break;

            case 3:
                player.displayCharacterStats();
                chooseActionOrItem(player, target);
            default:
                System.out.println("Invalid choice.");
        }


        return choice;
    }

    private static void selectAndUseItem(Character player, Character target){
        // Displaying available consumables in the inventory
        System.out.println("Available consumables:");
        List<Item> inventory = player.getInventory();
        if(inventory.size() < 1 || !player.hasUsableItems(inventory)){
            System.out.println("You don't have any usable items.");
            System.out.println();
            chooseActionOrItem(player, target);
            return;
        }
        for (int i = 0; i < inventory.size(); i++) {
            Item currentItem = inventory.get(i);
            if (currentItem instanceof UsableItem) {
                UsableItem usableItem = (UsableItem) currentItem;
                System.out.println((i + 1) + ": " + usableItem.getName() + " - " + usableItem.getDescription());
            }
        }
        // Prompting the player to select an action
        System.out.println();
        System.out.print("Select a consumable by entering its number: ");
        System.out.println();
        int choice = getPlayerChoice(player.getInventory().size());
//        // Go back if they choose 0;
//        if (choice == 0) {
//            return;
//        }
        // Using the consumable
        int itemIndex = choice;
        Item selectedItem = inventory.get(itemIndex);
        if (selectedItem instanceof UsableItem) {
            UsableItem usableItem = (UsableItem) selectedItem;
            usableItem.use(player);
            System.out.println("You used " + usableItem.getName() + ".");
        }
        else{
            chooseActionOrItem(player, target);
            return;
        }

        System.out.println();
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

        // Prompting the player to select an action
        System.out.println();
        System.out.print("Select an ability by entering its number: ");
        System.out.println();
        int choice = getPlayerChoice(player.getAbilities().size());
//        // Go back if they choose 0;
//        if (choice == 0) {
//            return;
//        }

        // Using the selected ability on the target
        if (choice <= player.getAbilities().size()) {
            int abilityIndex = choice;
            Ability selectedAbility = player.getAbilities().get(abilityIndex);
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
    }



}
