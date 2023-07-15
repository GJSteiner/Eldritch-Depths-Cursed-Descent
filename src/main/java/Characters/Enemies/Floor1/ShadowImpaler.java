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
    private static final int XP_YIELD = 15;
    private static final String ENEMY_TYPE = "Shadow Impaler";
    private static final String DESCRIPTION = "A shadowy creature with elongated limbs and sharp claws. It can merge with the darkness, becoming nearly invisible before launching surprise attacks.";
    ShadowImpalerCreator creator = new ShadowImpalerCreator();

    public ShadowImpaler(){
    }


    public List<String> setImpalerTags() {
        List<String> impalerTags = new ArrayList<>();
        impalerTags.add(allTags.getShadowEnemy());
        impalerTags.add(allTags.getStealthyEnemy());
        impalerTags.add(allTags.getAberrationEnemy());

        return impalerTags;
    }

    public ShadowImpaler(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setImpalerTags());
    }



    public ShadowImpaler level1Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Weak Shadow Impaler", 1);
        shadowImpaler.addTag(allTags.getWeakEnemy());
        shadowImpaler.addTag(allTags.getNormalEnemy());

        return shadowImpaler;
    }

        public ShadowImpaler level2Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Average Shadow Impaler", 2);
        shadowImpaler.addTag(allTags.getMediumEnemy());
        shadowImpaler.addTag(allTags.getNormalEnemy());

        return shadowImpaler;
    }

    public ShadowImpaler level3Shadow() {
        ShadowImpaler shadowImpaler = creator.create("Strong Shadow Impaler", 3);
        shadowImpaler.addTag(allTags.getStrongEnemy());
        shadowImpaler.addTag(allTags.getUniqueEnemy());


        return shadowImpaler;
    }



}
