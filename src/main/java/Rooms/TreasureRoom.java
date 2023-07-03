package Rooms;

import Characters.Player;
import Items.Item;

import java.util.List;

public class TreasureRoom extends Room{
    private List<Item> treasure;

    public TreasureRoom(String name, String description, List<Item> treasure) {
        super(name, description);
        this.treasure = treasure;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        if (!treasure.isEmpty()) {
            System.out.println("You found some treasure!");

            // Give the player the treasure items
            for (Item item : treasure) {
                player.addItemToInventory(item);
                System.out.println("You received: " + item.getName());
            }

            // Clear the treasure list
            treasure.clear();
        } else {
            System.out.println("There is no treasure in this room.");
        }
    }
}
