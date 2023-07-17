package Dungeons.Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Combat;

import java.util.ArrayList;
import java.util.List;

public class UniqueRoom extends Room{
    private Enemy unique;
    private List<Enemy> enemies;


    public UniqueRoom(String name, String description, List<Enemy> enemies) {
        super(name, description);
        this.enemies = enemies;
    }

    public Enemy getUnique() {
        return unique;
    }

    public void setUnique(Enemy unique) {
        this.unique = unique;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName() + ". You feel an unusually strong and ominous presence here.");
        System.out.println(getDescription());

        // Check if the boss and additional enemies are still alive
        boolean uniqueAlive = unique.isAlive();
            System.out.println("There is a powerful enemy, " + unique.getName() + " in the room!");

        if (uniqueAlive) {
            System.out.println("Prepare yourself for a challenging battle!");

            List<Enemy> allEnemies = new ArrayList<>();
            allEnemies.add(unique);

            Combat.startCombat(player, allEnemies);
        } else {
            // All enemies have already been defeated
            System.out.println("You have already defeated all enemies in this room.");
        }
    }
}
