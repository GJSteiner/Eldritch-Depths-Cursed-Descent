package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.VoidImp.DarkBlast;
import Abilities.Enemies.VoidImp.ImpFire;
import Abilities.Enemies.VoidImp.ShadowStep;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Characters.Enemies.Floor1.VoidImp;
import Items.Armor;
import Items.Armors.ArmorList;
import Items.Item;
import Items.Potion;
import Items.Potions.HealthPotions;
import Items.Weapon;
import Items.Weapons.WeaponList;

import java.util.ArrayList;
import java.util.List;


public class VoidImpCreator {
    private final Ability darkBlast = new DarkBlast();
    private final Ability shadowStep = new ShadowStep();
    private final Ability impFire = new ImpFire();

     List<Item> enemyInventory = new ArrayList<>();  // Assuming you have an inventory of items for the enemy
     List<Ability> enemyAbilities = new ArrayList<>();  // Assuming you have a list of abilities for the enemy
     List<Passive> enemyPassives = new ArrayList<>();  // Assuming you have a list of passives for the enemy

//    Potion healthPotion = new HealthPotions().createSmallHealthPotion();
    Potion impPotion = new HealthPotions().smallHealthPotion;
    Armor impArmor = new ArmorList().voidRobes;
    Weapon impWeapon = new WeaponList().voidDagger;


    public VoidImp create(String enemyName, int enemyLevel){

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);
        enemyAbilities.add(impFire);

        if(enemyLevel == 0){
// Create an inventory list for the Void Imp, provided it's level 0
            enemyInventory.add(impPotion);
            enemyInventory.add(impWeapon);
            enemyInventory.add(impArmor);
        }

        int enemyMaxHealth = enemyLevel + 50;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 5;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 2;
        boolean enemyAlive = true;

        VoidImp voidImp = new VoidImp(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives);
        return voidImp;
    }

}
