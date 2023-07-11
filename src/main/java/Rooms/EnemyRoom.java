package Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Combat;

import java.util.ArrayList;
import java.util.List;

public class EnemyRoom extends Room {
    private List<Enemy> enemies;

    public EnemyRoom(String name, String description, List<Enemy> enemies) {
        super(name, description);
        this.enemies = enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        // Check if there are any enemies alive in the room
        List<Enemy> aliveEnemies = new ArrayList<>();
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                aliveEnemies.add(enemy);
            }
        }

        if (aliveEnemies.isEmpty()) {
            System.out.println("You have already defeated all enemies in this room.");
        } else {
            System.out.println("There are " + aliveEnemies.size() + " enemies in the room!");
            System.out.println("It's time for a fight!");

            Combat.startCombat(player, aliveEnemies);

            // Remove defeated enemies from the room
            for (Enemy enemy : aliveEnemies) {
                if (!enemy.isAlive()) {
                    enemies.remove(enemy);
                }
            }

            player.makeChoice();
        }
    }
//    public void reset() {
//        for (Enemy enemy : enemies) {
//            enemy.setAlive(true);
//            enemy.setHealth(enemy.getMaxHealth());
//        }
//    }
}