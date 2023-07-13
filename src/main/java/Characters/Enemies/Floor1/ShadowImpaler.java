package Characters.Enemies.Floor1;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.ShadowImpalerCreator;
import Systems.EnemyCreators.VoidImpCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class ShadowImpaler extends Enemy {
    private static final int XP_YIELD = 20;
    private static final String ENEMY_TYPE = "Shadow Impaler";
    private static final String DESCRIPTION = "A shadowy creature with elongated limbs and sharp claws. It can merge with the darkness, becoming nearly invisible before launching surprise attacks.";


    private final EnemyTags allTags = new EnemyTags();
    private final List<String> enemyTags = new ArrayList<>();

    ShadowImpalerCreator creator = new ShadowImpalerCreator();

    public ShadowImpaler(){
    }

    public ShadowImpaler(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> enemyTags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives, enemyTags);
        enemyTags.add(allTags.getShadowEnemy());
        enemyTags.add(allTags.getStealthyEnemy());
        enemyTags.add(allTags.getAberrationEnemy());

    }



    public ShadowImpaler level1Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Weak Shadow Impaler", 1);
        shadowImpaler.getEnemyTags().add(allTags.getWeakEnemy());
        shadowImpaler.getEnemyTags().add(allTags.getNormalEnemy());

        return shadowImpaler;
    }

        public ShadowImpaler level2Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Average Shadow Impaler", 2);
        shadowImpaler.getEnemyTags().add(allTags.getMediumEnemy());
        shadowImpaler.getEnemyTags().add(allTags.getNormalEnemy());

        return shadowImpaler;
    }

    public ShadowImpaler level3Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Strong Shadow Impaler", 3);
        shadowImpaler.getEnemyTags().add(allTags.getStrongEnemy());
        shadowImpaler.getEnemyTags().add(allTags.getUniqueEnemy());

        return shadowImpaler;
    }

    public List<String> getEnemyTags() {
        return enemyTags;
    }


}
