package Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Combat;
import Systems.GameRunner;


public class EnemyRoom extends Room {
    private Enemy enemy;

    public EnemyRoom(String name, String description, Enemy enemy) {
        super(name, description);
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        // Check if the enemy is still alive
        if (enemy.isAlive()) {
            System.out.println("There is a " + enemy.getName() + "!");
            System.out.println("It's time for a fight!");
            Combat.startCombat(player, enemy);
            player.move();
        } else {
            // The enemy has already been defeated
            System.out.println("You have already defeated the enemy in this room.");
        }
    }
}