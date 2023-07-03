package Systems;

import Characters.Player;
import Dungeons.Dungeon;
import Floors.FloorLayout;
import Rooms.Room;

import java.util.List;
import java.util.Scanner;

public class GameRunner {
    public static Player player;
    public static Dungeon dungeon = new Dungeon();
    public static void main(String[] args) {
        ClassSelection.run();
        player = ClassSelection.player;
        try {
            initializeGame();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static void initializeGame() {

        while (!dungeon.isGameCompleted()) {
            FloorLayout currentFloorLayout = dungeon.getCurrentFloorLayout();
            Room currentRoom = currentFloorLayout.getStartingRoom();
            player.setCurrentRoom(currentRoom);

            System.out.println("You are now on Floor " + (dungeon.getCurrentFloorIndex() + 1));
            System.out.println("Explore the rooms and defeat the enemies to progress.");

            exploreDungeon(player, dungeon);

            dungeon.moveToNextFloor();
        }

        System.out.println("Congratulations! You have completed the dungeon!");
    }

//    private static void gameLoop(Player player, Dungeon dungeon) {
//        // Main game loop
//        while (player.isAlive() && !dungeon.isGameCompleted()) {
//            // Process player input, handle player actions
//            // Update game state (player, dungeon, enemies, etc.)
//            // Display game information, room description, player status, etc.
//        }
//    }

    private static void exploreDungeon(Player player, Dungeon dungeon) {
        while (true) {
            Room currentRoom = player.getCurrentRoom();

            System.out.println("Current Room: " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
            player.move();

            // Checking if the player has reached the end of the floor
            if (currentRoom.isEndRoom()) {
                System.out.println("Congratulations! You have cleared the floor!");
                break;
            }

        }
    }
}
