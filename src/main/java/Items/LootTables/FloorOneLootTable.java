package Items.LootTables;

import Characters.Player;
import Items.Equipment.Armors.Chest;
import Items.Equipment.EquipmentSlot;
import Items.Equipment.Weapons.MagicWeapon;
import Items.Equipment.Weapons.StrengthWeapon;
import Items.Equipment.Weapons.Weapon;
import Items.Item;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.SmallHealthPotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FloorOneLootTable {
    private static final List<Item> lootTable = new ArrayList<>();

    static {
        // Common Items
        lootTable.add(new StrengthWeapon("Iron Sword", "A sturdy iron sword", 1));
        lootTable.add(new Chest("Leather Armor", "Basic leather armor", 1));
        lootTable.add(new SmallHealthPotion());

        // Uncommon Items
        lootTable.add(new StrengthWeapon("Steel Dagger", "A sharp steel dagger", 2));
        lootTable.add(new Chest("Chainmail", "Durable chainmail armor",2));
        lootTable.add(new MediumHealthPotion());

        // Rare Items
        lootTable.add(new MagicWeapon("Staff of Fire", "A powerful staff imbued with fire magic", 3));
        lootTable.add(new Chest("Plate Armor", "Heavy plate armor", 3));
        lootTable.add(new LargeHealthPotion());
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