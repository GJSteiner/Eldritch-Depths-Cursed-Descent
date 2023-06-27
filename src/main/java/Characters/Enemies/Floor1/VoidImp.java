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

import java.util.ArrayList;
import java.util.List;

public class VoidImp extends Enemy {
    private static final int XP_YIELD = 50;
    private static final String ENEMY_TYPE = "Void Imp";
    private static final String DESCRIPTION = "A small imp from the void realm.";
    private static final List<Ability> VOID_IMP_ABILITIES = new ArrayList<>();
    private static final List<Item> VOID_IMP_INVENTORY = new ArrayList<>();
    private static final List<Passive> VOID_IMP_PASSIVES = new ArrayList<>();


    public VoidImp(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, XP_YIELD, ENEMY_TYPE, DESCRIPTION, VOID_IMP_INVENTORY, VOID_IMP_ABILITIES, VOID_IMP_PASSIVES);
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

    public static VoidImp level0Imp(){
        VoidImp voidImp = VoidImpCreator.create("Weak Void Imp", 0);
        return voidImp;
    }
    public static VoidImp level1Imp(){
        VoidImp voidImp = VoidImpCreator.create("Average Void Imp", 1);
        return voidImp;
    }
    public static VoidImp level2Imp(){
        VoidImp voidImp = VoidImpCreator.create("Strong Void Imp", 2);
        return voidImp;
    }

}
