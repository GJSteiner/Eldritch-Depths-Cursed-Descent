package Characters.Enemies.Floor1;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.VoidImpCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class VoidImp extends Enemy {
    private static int XP_YIELD = 15;
    private static final String ENEMY_TYPE = "Void Imp";
    private static final String DESCRIPTION = "A small imp from the void realm.";

//    private final EnemyTags allTags = new EnemyTags();

    VoidImpCreator creator = new VoidImpCreator();
    private List<String> setImpTags(){
        List<String> impTags = new ArrayList<>();
        impTags.add(allTags.getImpEnemy());
        impTags.add(allTags.getVoidEnemy());

        return impTags;
    }

    public VoidImp(){
    }

    public VoidImp(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives);
        setTags(setImpTags());
    }

    public VoidImp level0Imp() {
        VoidImp voidImp = creator.create("Weak Void Imp", 0);
        voidImp.addTag(allTags.getWeakEnemy());
        voidImp.addTag(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level1Imp() {
        VoidImp voidImp = creator.create("Average Void Imp", 1);
        voidImp.addTag(allTags.getMediumEnemy());
        voidImp.addTag(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level2Imp() {
        VoidImp voidImp = creator.create("Strong Void Imp", 2);
        voidImp.addTag(allTags.getStrongEnemy());
        voidImp.addTag(allTags.getNormalEnemy());

        return voidImp;
    }


}
