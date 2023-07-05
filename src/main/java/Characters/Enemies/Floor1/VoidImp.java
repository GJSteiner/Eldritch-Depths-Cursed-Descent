package Characters.Enemies.Floor1;

import Abilities.Ability;
import Abilities.Enemies.VoidImp.DarkBlast;
import Abilities.Enemies.VoidImp.ImpFire;
import Abilities.Enemies.VoidImp.ShadowStep;
import Abilities.Passive;
import Characters.Character;
import Characters.Enemies.Enemy;
import Items.Item;
import Systems.EnemyCreators.VoidImpCreator;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class VoidImp extends Enemy {
    private static final int XP_YIELD = 50;
    private static final String ENEMY_TYPE = "Void Imp";
    private static final String DESCRIPTION = "A small imp from the void realm.";
    private static final List<Ability> VOID_IMP_ABILITIES = new ArrayList<>();
    private static final List<Item> VOID_IMP_INVENTORY = new ArrayList<>();
    private static final List<Passive> VOID_IMP_PASSIVES = new ArrayList<>();
    private static final List<String> VOID_IMP_TAGS = new ArrayList<>();

    private final EnemyTags allTags = new EnemyTags();
    private final List<String> enemyTags = new ArrayList<>();

    VoidImpCreator creator = new VoidImpCreator();

    public VoidImp(){
    }

    public VoidImp(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> enemyTags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, VOID_IMP_INVENTORY, VOID_IMP_ABILITIES, VOID_IMP_PASSIVES, VOID_IMP_TAGS);
        enemyTags.add(allTags.getVoidEnemy());
        enemyTags.add(allTags.getImpEnemy());
    }

    static {

        Ability darkBlast = new DarkBlast();
        Ability impFire = new ImpFire();
        Ability shadowStep = new ShadowStep();

        VOID_IMP_ABILITIES.add(darkBlast);
        VOID_IMP_ABILITIES.add(impFire);
        VOID_IMP_ABILITIES.add(shadowStep);
    }

    private void addAbilities(Ability ability){
        VOID_IMP_ABILITIES.add(ability);
    }
    private void addPassives(Passive passive){
        VOID_IMP_PASSIVES.add(passive);
    }
    private void addItems(Item item){
        VOID_IMP_INVENTORY.add(item);
    }


    public VoidImp level0Imp() {
        VoidImp voidImp = creator.create("Weak Void Imp", 0);
        voidImp.getEnemyTags().add(allTags.getWeakEnemy());
        voidImp.getEnemyTags().add(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level1Imp() {
        VoidImp voidImp = creator.create("Average Void Imp", 1);
        voidImp.getEnemyTags().add(allTags.getMediumEnemy());
        voidImp.getEnemyTags().add(allTags.getNormalEnemy());

        return voidImp;
    }

    public VoidImp level2Imp() {
        VoidImp voidImp = creator.create("Strong Void Imp", 2);
        voidImp.getEnemyTags().add(allTags.getStrongEnemy());
        voidImp.getEnemyTags().add(allTags.getBossEnemy());

        return voidImp;
    }

    public List<String> getEnemyTags() {
        return enemyTags;
    }

}
