package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.VoidImp.DarkBlast;
import Abilities.Enemies.VoidImp.ImpFire;
import Abilities.Enemies.VoidImp.ShadowStep;
import Abilities.Passive;
import Characters.Enemies.Floor1.VoidImp;
import Items.Consumables.Potions.SmallHealthPotion;
import Items.Equipment.Armors.Armor;
import Items.Equipment.Armors.ArmorList;
import Items.Equipment.Weapons.Weapon;
import Items.Item;
import Items.Equipment.Weapons.WeaponList;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;


public class VoidImpCreator {
    EnemyTags tags = new EnemyTags();
    private final Ability darkBlast = new DarkBlast();
    private final Ability shadowStep = new ShadowStep();
    private final Ability impFire = new ImpFire();

    List<String> enemyTags = new ArrayList<>();
     List<Item> enemyInventory = new ArrayList<>();  // Assuming you have an inventory of items for the enemy
     List<Ability> enemyAbilities = new ArrayList<>();  // Assuming you have a list of abilities for the enemy
     List<Passive> enemyPassives = new ArrayList<>();  // Assuming you have a list of passives for the enemy

//    Potion healthPotion = new HealthPotions().createSmallHealthPotion();
    SmallHealthPotion weakImpPotion = new SmallHealthPotion();
    Armor weakImpArmor = new ArmorList().voidRobes;
    Weapon weakImpWeapon = new WeaponList().voidDagger;


    public VoidImp create(String enemyName, int enemyLevel){
        enemyTags.add(tags.getVoidEnemy());
        enemyTags.add(tags.getImpEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);
        enemyAbilities.add(impFire);

        if(enemyLevel == 0){
// Create an inventory list for the Void Imp, provided it's level 0
            enemyInventory.add(weakImpPotion);
            enemyInventory.add(weakImpWeapon);
            enemyInventory.add(weakImpArmor);
        }

        int enemyMaxHealth = (enemyLevel+1) * 10;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 2;
        boolean enemyAlive = true;

        VoidImp voidImp = new VoidImp(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives, enemyTags);
        return voidImp;
    }

}
