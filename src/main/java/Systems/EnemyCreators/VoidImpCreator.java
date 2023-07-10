package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.VoidImp.DarkBlast;
import Abilities.Enemies.VoidImp.ImpFire;
import Abilities.Enemies.VoidImp.ShadowStep;
import Abilities.Passive;
import Characters.Enemies.Floor1.VoidImp;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.SmallHealthPotion;
import Items.Equipment.Armors.*;
import Items.Equipment.OffHands.DefenseOffHand;
import Items.Equipment.OffHands.MagicOffHand;
import Items.Equipment.OffHands.StrengthOffHand;
import Items.Equipment.Weapons.*;
import Items.Item;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;


public class VoidImpCreator {
    EnemyTags tags = new EnemyTags();
    private final Ability darkBlast = new DarkBlast();
    private final Ability shadowStep = new ShadowStep();
    private final Ability impFire = new ImpFire();

    List<String> enemyTags = new ArrayList<>();
     List<Ability> enemyAbilities = new ArrayList<>();
     List<Passive> enemyPassives = new ArrayList<>();

//    Potion healthPotion = new HealthPotions().createSmallHealthPotion();
    SmallHealthPotion weakImpPotion = new SmallHealthPotion();
    MediumHealthPotion averageImpPotion = new MediumHealthPotion();
    LargeHealthPotion largeImpPotion = new LargeHealthPotion();
    Chest weakImpChest = new ArmorList().voidRobes;
    Legs weakImpGreaves = new ArmorList().voidwalkerLeggings;
    Hands weakImpGloves = new ArmorList().eldritchGrasps;
    Feet weakImpBoots = new ArmorList().voidwalkers;
    Helmet weakImpHelm = new ArmorList().forbiddenCowl;
    BalancedWeapon weakImpBalancedWeapon = new WeaponList().voidDagger;
    MagicWeapon weakImpMagicWeapon = new WeaponList().voidStaff;
    StrengthWeapon weakImpStrengthWeapon = new WeaponList().silverRapier;
    MagicOffHand weakImpMagicOffHand = new WeaponList().arcaneOrb;
    StrengthOffHand weakImpStrengthOffhand = new WeaponList().orbOfMight;
    DefenseOffHand weakImpDefenseOffHand = new WeaponList().blessedShield;


    public VoidImp create(String enemyName, int enemyLevel){
        List<Item> enemyInventory = new ArrayList<>();

        enemyTags.add(tags.getVoidEnemy());
        enemyTags.add(tags.getImpEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);
        enemyAbilities.add(impFire);

        if(enemyLevel == 0){
// Create an inventory list for the Void Imp, provided it's level 0
            enemyInventory.add(weakImpPotion);
            enemyInventory.add(weakImpGloves);
            enemyInventory.add(weakImpHelm);
            enemyInventory.add(weakImpBoots);
        }
        if(enemyLevel == 1){
            enemyInventory.add(weakImpPotion);
            enemyInventory.add(weakImpBalancedWeapon);
            enemyInventory.add(weakImpBalancedWeapon);
            enemyInventory.add(weakImpStrengthOffhand);
            enemyInventory.add(weakImpMagicOffHand);
            enemyInventory.add(weakImpDefenseOffHand);
        }
        if(enemyLevel == 2){
            enemyInventory.add(averageImpPotion);
            enemyInventory.add(weakImpStrengthWeapon);
            enemyInventory.add(weakImpMagicWeapon);
            enemyInventory.add(weakImpChest);
            enemyInventory.add(weakImpGreaves);
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
