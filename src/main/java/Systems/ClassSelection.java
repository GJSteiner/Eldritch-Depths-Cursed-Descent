package Systems;

import Abilities.Acolyte.AcolyteAbilities.BloodBolt;
import Abilities.Acolyte.AcolyteAbilities.BloodRain;
import Abilities.Acolyte.AcolyteAbilities.Drain;
import Abilities.Acolyte.AcolyteAbilities.VoidBolt;
import Abilities.Acolyte.AcolytePassives.Reserves;
import Characters.Player;

import java.util.Scanner;

public class ClassSelection {
    public static Player player;
    public static void run() {
        // Display class selection menu
        displayClassSelectionMenu();

        // Get player's class choice
        int choice = getPlayerChoice();

        // Create player based on the chosen class
        player = createPlayerFromClass(choice);

        // Start the game with the chosen player
        startGame(player);
    }

    private static void displayClassSelectionMenu() {
        System.out.println("=== Class Selection ===");
        System.out.println("Choose a class:");
        System.out.println("1. Acolyte");
        System.out.println("2. Crusader");
        System.out.println("3. Corrupted");
    }

    private static int getPlayerChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validChoice = false;

        while(!validChoice){
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice >=1 && choice <=3) {
                    validChoice = true;
                }
                else {
                    System.out.println("Invalid input. Please enter a number between 1 and 3 to choose your class.");
                }
            }
            else{
                System.out.println("Invalid input. Please enter a number to choose your class.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }

    private static Player createPlayerFromClass(int choice) {
        String name = getPlayerName();

        switch (choice) {
            case 1:
                return createAcolytePlayer(name);
            case 2:
                return createCrusaderPlayer(name);
            case 3:
                return createCorruptedPlayer(name);

            default:
                System.out.println("Invalid choice. Creating default player as Acolyte.");
                return createAcolytePlayer(name);
        }
    }

    private static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    private static Player createAcolytePlayer(String name) {
        // Initial stats for Acolyte
        int level = 0;
        int maxHealth = 80;
        int health = maxHealth;
        int magic = 8;
        int strength = 2;
        int defense = 2;
        boolean alive = true;

        // Create an Acolyte player instance
        Player player = new Player(name, level, maxHealth, health, magic, strength, defense, alive);

        player.addAbility(new VoidBolt());
        player.addAbility(new BloodBolt());
        player.addAbility(new Drain());
        player.addAbility(new BloodRain());
        player.addPassive(new Reserves());

        return player;
    }

    private static Player createCrusaderPlayer(String name) {
        // Initial stats for Crusader
        int level = 0;
        int maxHealth = 50;
        int health = maxHealth;
        int magic = 5;
        int strength = 5;
        int defense = 5;
        boolean alive = true;

        // Create a Crusader player instance
        return new Player(name, level, maxHealth, health, magic, strength, defense, alive);
    }
    private static Player createCorruptedPlayer(String name) {
        // Initial stats for Corrupted
        int level = 0;
        int maxHealth = 50;
        int health = maxHealth;
        int magic = 10;
        int strength = 1;
        int defense = 5;
        boolean alive = true;

        // Create a Corrupted player instance
        return new Player(name, level, maxHealth, health, magic, strength, defense, alive);
    }

    private static void startGame(Player player) {
        // Start your game with the chosen player
        System.out.println("Game started with " + player.getName() + " as the chosen class!");
        // Add your game logic here
    }
}
