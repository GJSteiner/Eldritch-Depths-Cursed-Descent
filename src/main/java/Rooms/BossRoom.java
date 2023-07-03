package Rooms;

import Characters.Enemies.Enemy;
import Characters.Player;
import Systems.Combat;

public class BossRoom extends Room {
    private Enemy boss;

    public BossRoom(String name, String description, Enemy boss) {
        super(name, description);
        this.boss = boss;
    }

    public Enemy getBoss() {
        return boss;
    }

    public void setBoss(Enemy boss) {
        this.boss = boss;
    }

    public void enterRoom(Player player) {
        System.out.println("You have entered the " + getName());
        System.out.println(getDescription());

        // Check if the boss is still alive
        if (boss.isAlive()) {
            System.out.println("There is a powerful boss, " + boss.getName() + "!");
            System.out.println("Prepare yourself for a challenging battle!");
            Combat.startCombat(player, boss);
        } else {
            // The boss has already been defeated
            System.out.println("You have already defeated the boss in this room.");
        }
    }
}