package Dungeons.Rooms;

import Characters.Player;

public class StartingRoom extends Room{

        public StartingRoom(String name, String description) {
            super(name, description);
        }

        public void enterRoom(Player player) {
            System.out.println("You have entered the " + getName());
            System.out.println(getDescription());
            System.out.println();


            // Update player's current room
            player.setCurrentRoom(this);
        }

//    @Override
//    public void reset() {
//
//    }

}
