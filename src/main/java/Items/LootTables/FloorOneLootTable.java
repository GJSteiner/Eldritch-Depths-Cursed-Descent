package Items.LootTables;

import Characters.Player;
import Items.Armor;
import Items.Item;
import Items.Potion;
import Items.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloorOneLootTable {
    private static final List<Item> lootTable = new ArrayList<>();

    static {
        // Common Items
        lootTable.add(new Weapon("Iron Sword", "A sturdy iron sword", 0, 5));
        lootTable.add(new Armor("Leather Armor", "Basic leather armor", 2, 0));
        lootTable.add(new Potion("Health Potion", "Restores 20 health points", 20, 0));

        // Uncommon Items
        lootTable.add(new Weapon("Steel Dagger", "A sharp steel dagger", 0, 3));
        lootTable.add(new Armor("Chainmail", "Durable chainmail armor", 4, 0));
        lootTable.add(new Potion("Magic Potion", "Restores 20 magic points", 0, 20));

        // Rare Items
        lootTable.add(new Weapon("Staff of Fire", "A powerful staff imbued with fire magic", 10, 0));
        lootTable.add(new Armor("Plate Armor", "Heavy plate armor", 8, 0));
        lootTable.add(new Potion("Elixir of Strength", "Temporarily increases strength by 5", 0, 0));
    }

    public static void getRandomLoot(Player player) {
        Random random = new Random();
        int index = -1;
        int rarityRoll = random.nextInt(100); // Generate a random number between 0 and 99

        // Adjust the probabilities based on rarity
        if (rarityRoll < 60) { // 60% chance for common items
            index = random.nextInt(3); // Select a random index for common items
        } else if (rarityRoll < 90) { // 30% chance for uncommon items
            index = random.nextInt(6 - 3) + 3; // Select a random index for uncommon items
        } else { // 10% chance for rare items
            index = random.nextInt(9 - 6) + 6; // Select a random index for rare items
        }

        Item item = lootTable.get(index);
        player.addItemToInventory(item);
    }
}