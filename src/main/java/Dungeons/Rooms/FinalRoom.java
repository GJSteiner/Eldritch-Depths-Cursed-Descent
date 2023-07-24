package Dungeons.Rooms;

import Characters.Player;

public class FinalRoom extends Room{

        public FinalRoom(String name, String description) {
            super(name, description);
        }

        public void enterRoom(Player player) {
            System.out.println("Congratulations! You have defeated the final boss and cleared the dungeon!");
            System.out.println();


            // Update player's current room
            player.setCurrentRoom(this);
        }



}
