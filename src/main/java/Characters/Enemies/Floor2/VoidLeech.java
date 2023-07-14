package Characters.Enemies.Floor2;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.VoidLeechCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class VoidLeech extends Enemy {
    private static final int XP_YIELD = 20;
    private static final String ENEMY_TYPE = "Void Leech";
    private static final String DESCRIPTION = "A parasitic creature from the void, it drains life energy from its victims to sustain itself.";

    private final EnemyTags allTags = new EnemyTags();
    private final List<String> enemyTags = new ArrayList<>();

    VoidLeechCreator creator = new VoidLeechCreator();

    public VoidLeech() {
    }

    public List<String> setLeechTags() {
        List<String> leechTags = new ArrayList<>();
        leechTags.add(allTags.getVoidEnemy());
        leechTags.add(allTags.getLeechEnemy());
        return leechTags;
    }

    public VoidLeech(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setLeechTags());
    }

    public VoidLeech level2Leech() {
        VoidLeech voidLeech = creator.create("Fresh Void Leech", 2);
        voidLeech.getEnemyTags().add(allTags.getWeakEnemy());
        voidLeech.getEnemyTags().add(allTags.getNormalEnemy());

        return voidLeech;
    }

    public VoidLeech level3Leech() {
        VoidLeech voidLeech = creator.create("Plump Void Leech", 3);
        voidLeech.getEnemyTags().add(allTags.getMediumEnemy());
        voidLeech.getEnemyTags().add(allTags.getNormalEnemy());

        return voidLeech;
    }

    public VoidLeech level4Leech() {
        VoidLeech voidLeech = creator.create("Gluttonous Void Leech", 4);
        voidLeech.getEnemyTags().add(allTags.getStrongEnemy());
        voidLeech.getEnemyTags().add(allTags.getNormalEnemy());

        return voidLeech;
    }

    public List<String> getEnemyTags() {
        return enemyTags;
    }
}