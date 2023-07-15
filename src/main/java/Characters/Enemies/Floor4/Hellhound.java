package Characters.Enemies.Floor4;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor2.VoidLeech;
import Items.Item;
import Systems.EnemyCreators.HellhoundCreator;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class Hellhound extends Enemy {
    private static final int XP_YIELD = 30;
    private static final String ENEMY_TYPE = "Hellhound";
    private static final String DESCRIPTION = "A demonic canine with glowing purple eyes and smoldering fur engulfed in indigo flames.";


    HellhoundCreator creator = new HellhoundCreator();

    public Hellhound() {
    }

    public List<String> setHellhoundTags() {
        List<String> hellhoundTags = new ArrayList<>();
        hellhoundTags.add(allTags.getBeastEnemy());
        hellhoundTags.add(allTags.getCanineEnemy());
        return setHellhoundTags();
    }

    public Hellhound(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setHellhoundTags());
    }

    public Hellhound level6Hellhound() {
        Hellhound hellhound = creator.create("Hellhound Pup", 6);
        hellhound.addTag(allTags.getWeakEnemy());
        hellhound.addTag(allTags.getNormalEnemy());

        return hellhound;
    }

    public Hellhound level7Hellhound() {
        Hellhound hellhound = creator.create("Hellhound Adult", 7);
        hellhound.addTag(allTags.getMediumEnemy());
        hellhound.addTag(allTags.getNormalEnemy());

        return hellhound;
    }

    public Hellhound level8Hellhound() {
        Hellhound hellhound = creator.create("Hellhound Cerberus", 8);
        hellhound.addTag(allTags.getStrongEnemy());
        hellhound.addTag(allTags.getNormalEnemy());

        return hellhound;
    }

}