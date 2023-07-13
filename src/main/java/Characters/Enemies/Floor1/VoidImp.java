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

    public VoidImp(){
    }

    public VoidImp(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> enemyTags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, inventory, abilities, passives, enemyTags);
        enemyTags.add(allTags.getVoidEnemy());
        enemyTags.add(allTags.getImpEnemy());
    }

    // getting all this from the voidImpCreator instead
//    static {
//
//        Ability darkBlast = new DarkBlast();
//        Ability impFire = new ImpFire();
//        Ability shadowStep = new ShadowStep();
//
//        VOID_IMP_ABILITIES.add(darkBlast);
//        VOID_IMP_ABILITIES.add(impFire);
//        VOID_IMP_ABILITIES.add(shadowStep);
//    }

//    private void addAbilities(Ability ability){
//        VOID_IMP_ABILITIES.add(ability);
//    }
//    private void addPassives(Passive passive){
//        VOID_IMP_PASSIVES.add(passive);
//    }
//    private void addItems(Item item){
//        VOID_IMP_INVENTORY.add(item);
//    }


    public VoidImp level0Imp() {
        VoidImp voidImp = creator.create("Weak Void Imp", 0);
        voidImp.addEnemyTag(allTags.getWeakEnemy());
        voidImp.addEnemyTag(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level1Imp() {
        VoidImp voidImp = creator.create("Average Void Imp", 1);
        voidImp.addEnemyTag(allTags.getMediumEnemy());
        voidImp.addEnemyTag(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level2Imp() {
        VoidImp voidImp = creator.create("Strong Void Imp", 2);
        voidImp.addEnemyTag(allTags.getStrongEnemy());
        voidImp.addEnemyTag(allTags.getNormalEnemy());

        return voidImp;
    }


}
