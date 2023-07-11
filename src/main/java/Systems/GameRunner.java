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
        run();
    }

    public static void run(){
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
            System.out.println();
            System.out.println("You are now on Floor " + (dungeon.getCurrentFloorIndex() + 1));
            System.out.println("Explore the rooms and defeat the enemies to progress.");

            exploreDungeon(player, dungeon);

            dungeon.moveToNextFloor();
        }

        System.out.println("Congratulations! You have completed the dungeon!");
    }

    private static void exploreDungeon(Player player, Dungeon dungeon) {
        while (true) {
            Room currentRoom = player.getCurrentRoom();

//            System.out.println();
//            System.out.println("Current Room: " + currentRoom.getName());
//            System.out.println();
//            System.out.println(currentRoom.getDescription());
            player.makeChoice();

            // Checking if the player has reached the end of the floor
            if (currentRoom.isEndRoom()) {
//                System.out.println("Congratulations! You have cleared the floor!");
                dungeon.moveToNextFloor();

            }

        }
    }
    public static void gameOver(Player player) {
        System.out.println();
        System.out.println("Game Over!");
        System.out.println(player.getName() + " has been defeated.");
        System.out.println("Better luck next time!");
        System.out.println();
        System.out.println("Would you like to start over?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int choice = getPlayerChoice(2)+1;
        if(choice == 1){
            restartGame();
        }
        else {
            System.out.println("Thank you for playing. Goodbye!");
            System.exit(0); // Terminate the application
        }
    }
    static int getPlayerChoice(int maxChoice) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 1 || choice > maxChoice) {
                    System.out.print("Invalid choice. Please enter a number between 1 and " + maxChoice + ": ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number between 1 and " + maxChoice + ": ");
            }
        }

        return choice - 1;
    }


    private static void restartGame() {
        // Reset player's data
        player.reset();

        // Reset dungeon data
        dungeon.reset();

        // Reset floor data
        for (int i = 0; i < dungeon.getFloors().size(); i++) {
            dungeon.getFloors().get(i).reset();
        }

        // Restart the game
        run();
    }
}
