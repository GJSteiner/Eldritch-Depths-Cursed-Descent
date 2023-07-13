package Dungeons.Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Combat;

import java.util.ArrayList;
import java.util.List;

public class BossRoom extends Room {
    private Enemy boss;
    private List<Enemy> additionalEnemies;

    public BossRoom(String name, String description, Enemy boss, List<Enemy> additionalEnemies) {
        super(name, description);
        this.boss = boss;
        this.additionalEnemies = additionalEnemies;
    }

    public Enemy getBoss() {
        return boss;
    }

    public void setBoss(Enemy boss) {
        this.boss = boss;
    }

    public List<Enemy> getAdditionalEnemies() {
        return additionalEnemies;
    }

    public void setAdditionalEnemies(List<Enemy> additionalEnemies) {
        this.additionalEnemies = additionalEnemies;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        // Check if the boss and additional enemies are still alive
        boolean bossAlive = boss.isAlive();
        boolean additionalEnemiesAlive = false;
        for (Enemy enemy : additionalEnemies) {
            if (enemy.isAlive()) {
                additionalEnemiesAlive = true;
                break;
            }
        }

        if (additionalEnemies.size() > 0){
            System.out.println("There is a powerful boss, " + boss.getName() + " in the room!");
        }else{
            System.out.println("There is a powerful boss, " + boss.getName() + ", and additional enemies in the room!");
        }
        if (bossAlive || additionalEnemiesAlive) {
            System.out.println("Prepare yourself for a challenging battle!");

            List<Enemy> allEnemies = new ArrayList<>();
            allEnemies.addAll(additionalEnemies);
            allEnemies.add(boss);

            Combat.startCombat(player, allEnemies);
        } else {
            // All enemies have already been defeated
            System.out.println("You have already defeated all enemies in this room.");
        }
    }
//    public void reset() {
//        boss.setAlive(true);
//        for (Enemy enemy : additionalEnemies) {
//            enemy.setAlive(true);
//        }
//    }
}