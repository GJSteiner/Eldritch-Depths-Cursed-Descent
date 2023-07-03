package Rooms;

import Characters.Player;

public class StartingRoom extends Room{

        public StartingRoom(String name, String description) {
            super(name, description);
        }

        public void enterRoom(Player player) {
            System.out.println("You have entered the " + getName());
            System.out.println(getDescription());

            // Additional logic specific to the starting room, if any

            // Example: Provide some guidance or instructions to the player

            System.out.println("You find yourself in a dimly lit room. It seems to be the entrance to the dungeon.");
            System.out.println("Your objective is to explore the dungeon, defeat enemies, and reach the end of each floor.");
            System.out.println("There are five floors in this dungeon, a boss on each floor, and the Dungeon Boss on the end of floor five.");

            // Update player's current room
            player.setCurrentRoom(this);
        }

}
