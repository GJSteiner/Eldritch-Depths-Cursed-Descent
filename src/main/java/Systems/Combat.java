package Systems;

import Abilities.Enemies.EnemyPassives.Expunge;
import Abilities.Passive;
import Characters.Character;
import Abilities.Ability;
import Characters.Enemies.Enemy;
import Characters.Player;
import Dungeons.Floors.FirstFloor.FirstFloorLayout;
import Items.Consumables.UsableItem;
import Items.Item;
import Systems.StatusEffects.StatusEffect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Systems.GameRunner.gameOver;
import static Systems.GameRunner.getPlayerChoice;

public class Combat {
    private static List<Enemy> enemies = new ArrayList<>();

    public static void startCombat(Player player, List<Enemy> aliveEnemies) {

        enemies = aliveEnemies;
        boolean bossEnemyRoom = false;
        if (enemies.size() == 1) {
            System.out.println();
            System.out.println("A battle begins between " + player.getName() + " and " + enemies.get(0).getName() + "!");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("A battle begins between " + player.getName() + " and multiple enemies!");
            System.out.println();

        }
        if (enemies.size() > 1) {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).displayCharacterStats();
                if (enemies.get(i) != null && enemies.get(i).getTags() != null && checkBossEnemy(enemies.get(i))) {
                    bossEnemyRoom = true;
                }
            }
        }
        System.out.println();
        player.displayPlayerStats();

        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if(enemy.isAlive()) {
                System.out.println("Enemy Number " + i);
                enemy.displayCharacterStats();
                System.out.println();
            }
            else{
                System.out.println("All enemies have been defeated.");
                System.out.println();
                break;
            }
            while (player.isAlive() && enemy.isAlive()) {
                // Player's turn
                System.out.println(player.getName() + "'s turn:");
                System.out.println();
                System.out.println(player.getName() + "'s Health: " + player.getHealth() + " HP");
                System.out.println(enemy.getName() + "'s Health: " + enemy.getHealth() + " HP");
                System.out.println();
                chooseActionOrItem(player, enemy, enemies);

                if (!enemy.isAlive()) {
                    //condensed into its own handleDefeatedEnemy method
//                    System.out.println(enemy.getName() + " has been defeated. " + player.getName() + " wins!");
//                    player.gainExperience(enemy.getXpYield(enemy.getLevel()));
//                    System.out.println("Exp: " + player.getExperience() + "/" + player.calculateExperienceThreshold());
//
//                    int droppedGold = enemy.dropGold();
//                    player.addGold(droppedGold);
//                    System.out.println("You have gained " + droppedGold + " gold!");
//                    System.out.println("You now have " + player.getGold() + " gold.");
//                    System.out.println();
//                    // boss drops 2 items
//                    if(checkBossEnemy(enemy)){
//                        dropAndPickupItem(player, enemy);
//                    }
//                    dropAndPickupItem(player, enemy);
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
                player.updateHealOverTime();
                enemy.updateHealOverTime();

                // Displaying dot damage for player
                for (DamageOverTime dot : player.getDamageOverTimeEffects()) {
                    System.out.println(player.getName() + " takes " + dot.getDamagePerRound() + " damage from " + dot.getDotName() + ".");
                }

                // Displaying dot damage for enemy
                for (DamageOverTime dot : enemy.getDamageOverTimeEffects()) {
                    System.out.println(enemy.getName() + " takes " + dot.getDamagePerRound() + " damage from " + dot.getDotName() + ".");
                }
                System.out.println();

                // Displaying hot for player
                for (HealOverTime hot : player.getHealOverTimeEffects()) {
                    System.out.println(player.getName() + " heals " + hot.getHealthPerRound() + " health from " + hot.getHotName() + ".");
                }

                // Displaying hot for enemy
                for (HealOverTime hot : enemy.getHealOverTimeEffects()) {
                    System.out.println(enemy.getName() + " heals " + hot.getHealthPerRound() + " health from " + hot.getHotName() + ".");
                }
                System.out.println();

                handleEnemyPassives(enemy, player);
            }
        }
        if (player.getCurrentRoom().isEndRoom()) {
            System.out.println("Congratulations! You have defeated this floor's boss and cleared the floor!");

        } else if (enemies.size() == 1) {
            System.out.println("The battle against " + enemies.get(0).getName() + " has ended.");
            enemies.clear();
        } else {
            System.out.println("The battle has ended.");
            enemies.clear();
        }
        endCombat(player);
        player.makeChoice();

    }

    private static int chooseActionOrItem(Player player, Enemy target, List<Enemy> enemies) {

        int choice = 0;
        System.out.println("1. Attack");
        System.out.println("2. Use Item");
        System.out.println("3. Check Stats");
        choice = getPlayerChoice(3) + 1;

        switch (choice) {
            case 1:
                selectAndUseAbility(player, target, enemies);
                break;
            case 2:
                selectAndUseItem(player, target, enemies);
                break;

            case 3:
                player.displayCharacterStats();
                chooseActionOrItem(player, target, enemies);
            default:
                System.out.println("Invalid choice.");
        }


        return choice;
    }

    private static void selectAndUseItem(Player player, Enemy target, List<Enemy> enemies) {
        checkStun(player);
        // Displaying available consumables in the inventory
        System.out.println("Available consumables:");
        List<Item> inventory = player.getInventory();
        if (inventory.size() < 1 || !player.hasUsableItems(inventory)) {
            System.out.println("You don't have any usable items.");
            System.out.println();
            chooseActionOrItem(player, target, enemies);
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
        } else {
            chooseActionOrItem(player, target, enemies);
            return;
        }

        System.out.println();
    }

    private static void selectAndUseAbility(Player player, Enemy target, List<Enemy> enemies) {
        checkStun(player);
        // Displaying available abilities to the user
        System.out.println("Available abilities:");
        for (int i = 0; i < player.getAbilities().size(); i++) {
            Ability currentAbility = player.getAbilities().get(i);
            if (currentAbility.getLevelRequirement() <= player.getLevel()) {
                System.out.println((i + 1) + ": " + currentAbility.getName() + " - " + currentAbility.getDescription());
            }
        }

        // Prompting the player to select an action
        System.out.println();
        System.out.print("Select an ability by entering its number: ");
        System.out.println();
        int choice = getPlayerChoice(player.getAbilities().size());
        if (choice <= player.getAbilities().size()) {
            int abilityIndex = choice;
            Ability selectedAbility = player.getAbilities().get(abilityIndex);
            if (selectedAbility.isAoe()) {
                selectedAbility.useAbilityAoe(player, enemies);
                for (Enemy enemy : enemies){
                    handleDefeatedEnemy(player, enemy);
                }
            } else {
                selectedAbility.useAbility(player, target);
                if(!target.isAlive()){
                    handleDefeatedEnemy(player, target);
                }
            }
        }


        System.out.println();
    }

    private static void endCombat(Character player) {
        player.removeAllStatusEffects();
    }
    private static void checkStun(Character character){
        for (StatusEffect effect : character.getActiveStatusEffects()) {
            if (effect.getTag().equals("Stun")) {
                System.out.println(character.getName() + " is stunned and cannot take any action this turn.");
                return;
            }
        }
    }

    private static void npcUseAbility(Character npc, Character target) {
        checkStun(npc);
        List<Ability> abilities = npc.getAbilities();

        if (abilities.isEmpty()) {
            System.out.println(npc.getName() + " has no available abilities.");
            return;
        }

        Random random = new Random();
        Ability randomAbility = null;
        boolean validAbility = false;
        // Check to make sure that a npc only uses an ability that they're the proper level to use
        while (!validAbility) {
            int randomIndex = random.nextInt(abilities.size());
            randomAbility = abilities.get(randomIndex);
            if (randomAbility.getLevelRequirement() <= npc.getLevel()) {
                validAbility = true;
            }

        }
        randomAbility.useAbility(npc, target);
        if (randomAbility.getAbilityElement().equals("Summoning")) {
            int randomIndex = random.nextInt(randomAbility.getSummons().size());
            Enemy randomEnemy = randomAbility.getSummons().get(randomIndex);
            enemies.add(randomEnemy);
            System.out.println(npc + " has summoned a " + randomEnemy.getName() + "!");
        }
    }

    public static void handleEnemyPassives(Character character, Character target) {
        //expunge
        for (Passive passive : character.getPassives()) {
            if (passive instanceof Expunge) {
                ((Expunge) passive).applyExpunge(character, target);
                break;
            }
        }
    }

    private static void handleDefeatedEnemy(Player player, Enemy enemy) {
        if (!player.isAlive()) {
            // if the player is defeated, do nothing
            return;
        }
        System.out.println();
        System.out.println(enemy.getName() + " has been defeated. " + player.getName() + " wins!");

        player.gainExperience(enemy.getXpYield(enemy.getLevel()));
        System.out.println("Exp: " + player.getExperience() + "/" + player.calculateExperienceThreshold());

        int droppedGold = enemy.dropGold();
        player.addGold(droppedGold);
        System.out.println("You have gained " + droppedGold + " gold!");
        System.out.println("You now have " + player.getGold() + " gold.");
        System.out.println();

        // boss drops 2 items
        if (checkBossEnemy(enemy)) {
            dropAndPickupItem(player, enemy);
        }

        dropAndPickupItem(player, enemy);
    }

    public static void dropAndPickupItem(Character player, Enemy enemy) {
        Item droppedItem = enemy.dropRandomItem();
        if (droppedItem != null) {
            System.out.println(enemy.getName() + " dropped a " + droppedItem.getName() + "!");
            System.out.println(player.getName() + " picked up a " + droppedItem.getName() + ".");
            player.getInventory().add(droppedItem);
        }
    }

    public static boolean checkBossEnemy(Enemy enemy) {
        return enemy.getTags().contains("Boss");
    }
}
