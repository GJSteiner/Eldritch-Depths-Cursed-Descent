package Systems;

import Characters.Character;

import java.util.ArrayList;
import java.util.List;

//Use the Character Manager whenever there are group encounters. Use the .addEnemy to populate the manager with
//all enemies in the encounter, then the .removeEnemy whenever they die or .removeAll to refresh the list in
//the event of running from an encounter or something similar.

public class CharacterManager {
    private static List<Character> enemies;

    static {
        enemies = new ArrayList<>();
        // Add your enemy characters here
        // Example:
        // enemies.add(new Enemy("Enemy 1", 10, 50, 50, 10, 5, 5, true));
        // enemies.add(new Enemy("Enemy 2", 15, 80, 80, 20, 8, 8, true));
    }

    public static List<Character> getEnemies() {
        return enemies;
    }

    public static void addEnemy(Character enemy) {
        enemies.add(enemy);
    }

    public static void removeEnemy(Character enemy) {
        enemies.remove(enemy);
    }
    public static void removeAll(){
        for (int i = 0; i < enemies.size(); i++) {
            enemies.remove(enemies.get(i));
        }
    }
}