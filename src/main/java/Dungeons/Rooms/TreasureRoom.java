package Dungeons.Rooms;

import Characters.Player;
import Items.Item;

import java.util.List;

public class TreasureRoom extends Room{
    private List<Item> treasures;

    public TreasureRoom(String name, String description, List<Item> treasure) {
        super(name, description);
        this.treasures = treasure;
    }

    public void addTreasure(Item treasure) {
            treasures.add(treasure);
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        if (!treasures.isEmpty()) {
            System.out.println("You found some treasure!");

            // Give the player the treasure items
            for (Item item : treasures) {
                player.addItemToInventory(item);
                System.out.println("You received: " + item.getName());
            }

            // Clear the treasure list
            treasures.clear();
        } else {
            System.out.println("There is no more treasure in this room.");
        }
        player.makeChoice();
    }
//    public void reset() {
//
//    }
}
