package Characters.Enemies.Floor2;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.AbyssElementalCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class AbyssElemental extends Enemy {
    private static final int XP_YIELD = 100;
    private static final String ENEMY_TYPE = "Abyss Elemental";
    private static final String DESCRIPTION = "A malevolent creature born from the depths of the abyss. It harnesses the power of darkness and water to attack its foes.";

    private final EnemyTags allTags = new EnemyTags();
    private final List<String> enemyTags = new ArrayList<>();

    AbyssElementalCreator creator = new AbyssElementalCreator();

    public AbyssElemental() {
    }

    public AbyssElemental(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> enemyTags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives, enemyTags);
        enemyTags.add(allTags.getWaterEnemy());
        enemyTags.add(allTags.getShadowEnemy());
        enemyTags.add(allTags.getElementalEnemy());
    }

    public AbyssElemental level1Abyss() {
        AbyssElemental abyssElemental = creator.create("Lesser Abyss Elemental", 1);
        abyssElemental.getEnemyTags().add(allTags.getWeakEnemy());
        abyssElemental.getEnemyTags().add(allTags.getNormalEnemy());

        return abyssElemental;
    }

    public AbyssElemental level2Abyss() {
        AbyssElemental abyssElemental = creator.create("Greater Abyss Elemental", 2);
        abyssElemental.getEnemyTags().add(allTags.getMediumEnemy());
        abyssElemental.getEnemyTags().add(allTags.getNormalEnemy());

        return abyssElemental;
    }

    public AbyssElemental level3Abyss() {
        AbyssElemental abyssElemental = creator.create("Elder Abyss Elemental", 3);
        abyssElemental.getEnemyTags().add(allTags.getStrongEnemy());
        abyssElemental.getEnemyTags().add(allTags.getBossEnemy());

        return abyssElemental;
    }

    public List<String> getEnemyTags() {
        return enemyTags;
    }
}