package Items.LootTables;

import Characters.Player;
import Items.Equipment.Armors.Chest;
import Items.Equipment.EquipmentSlot;
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
        lootTable.add(new Weapon("Iron Sword", "A sturdy iron sword", EquipmentSlot.WEAPON, 0, 3,  0, 0));
        lootTable.add(new Chest("Leather Armor", "Basic leather armor", EquipmentSlot.CHEST,0, 0, 2, 0));
        lootTable.add(new SmallHealthPotion());

        // Uncommon Items
        lootTable.add(new Weapon("Steel Dagger", "A sharp steel dagger", EquipmentSlot.WEAPON, 0, 5, 0 , 0));
        lootTable.add(new Chest("Chainmail", "Durable chainmail armor",EquipmentSlot.CHEST,0, 0, 4, 0));
        lootTable.add(new MediumHealthPotion());

        // Rare Items
        lootTable.add(new Weapon("Staff of Fire", "A powerful staff imbued with fire magic", EquipmentSlot.WEAPON, 10, 0, 0, 0));
        lootTable.add(new Chest("Plate Armor", "Heavy plate armor",EquipmentSlot.CHEST,0, 0, 8, 0));
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