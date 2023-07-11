package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.DarkBlast;
import Abilities.Enemies.ShadowStep;
import Abilities.Passive;
import Characters.Enemies.Floor1.ShadowImpaler;
import Items.Consumables.Potions.LargeHealthPotion;
import Items.Consumables.Potions.MediumHealthPotion;
import Items.Consumables.Potions.SmallHealthPotion;
import Items.Equipment.Armors.*;
import Items.Equipment.OffHands.DefenseOffHand;
import Items.Equipment.OffHands.MagicOffHand;
import Items.Equipment.OffHands.StrengthOffHand;
import Items.Equipment.Weapons.BalancedWeapon;
import Items.Equipment.Weapons.MagicWeapon;
import Items.Equipment.Weapons.StrengthWeapon;
import Items.Equipment.Weapons.WeaponList;
import Items.Item;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;

public class ShadowImpalerCreator {

    EnemyTags tags = new EnemyTags();
    private final Ability darkBlast = new DarkBlast();
    private final Ability shadowStep = new ShadowStep();

    List<String> enemyTags = new ArrayList<>();
    List<Ability> enemyAbilities = new ArrayList<>();
    List<Passive> enemyPassives = new ArrayList<>();
    SmallHealthPotion weakPotion = new SmallHealthPotion();
    MediumHealthPotion averagePotion = new MediumHealthPotion();
    LargeHealthPotion largePotion = new LargeHealthPotion();
    Chest weakChest = new ArmorList().voidRobes;
    Legs weakGreaves = new ArmorList().voidwalkerLeggings;
    Hands weakGloves = new ArmorList().eldritchGrasps;
    Feet weakBoots = new ArmorList().voidwalkers;
    Helmet weakHelm = new ArmorList().forbiddenCowl;
    BalancedWeapon weakBalancedWeapon = new WeaponList().voidDagger;
    MagicWeapon weakMagicWeapon = new WeaponList().voidStaff;
    StrengthWeapon weakStrengthWeapon = new WeaponList().silverRapier;
    MagicOffHand weakMagicOffHand = new WeaponList().arcaneOrb;
    StrengthOffHand weakStrengthOffhand = new WeaponList().orbOfMight;
    DefenseOffHand weakDefenseOffHand = new WeaponList().blessedShield;


    public ShadowImpaler create(String enemyName, int enemyLevel){
        List<Item> enemyInventory = new ArrayList<>();

        enemyTags.add(tags.getVoidEnemy());
        enemyTags.add(tags.getImpEnemy());

        enemyAbilities.add(darkBlast);
        enemyAbilities.add(shadowStep);

        if(enemyLevel == 0){
// Create an inventory list for the Void Imp, provided it's level 0
            enemyInventory.add(weakPotion);
            enemyInventory.add(weakPotion);
            enemyInventory.add(weakHelm);
            enemyInventory.add(weakBoots);
        }
        if(enemyLevel == 1){
            enemyInventory.add(weakPotion);
            enemyInventory.add(weakBalancedWeapon);
            enemyInventory.add(weakBalancedWeapon);
            enemyInventory.add(weakStrengthOffhand);
            enemyInventory.add(weakMagicOffHand);
            enemyInventory.add(weakDefenseOffHand);
        }
        if(enemyLevel == 2){
            enemyInventory.add(averagePotion);
            enemyInventory.add(weakStrengthWeapon);
            enemyInventory.add(weakMagicWeapon);
            enemyInventory.add(weakChest);
            enemyInventory.add(weakGreaves);
        }

        int enemyMaxHealth = (enemyLevel+1) * 7;
        int enemyHealth = enemyMaxHealth;
        int enemyMagic = (enemyLevel + 1) * 2;
        int enemyStrength = (enemyLevel + 1) * 5;
        int enemyDefense = (enemyLevel + 1) * 2;
        boolean enemyAlive = true;

        ShadowImpaler shadowImpaler = new ShadowImpaler(enemyName, enemyLevel, enemyMaxHealth, enemyHealth, enemyMagic, enemyStrength, enemyDefense, enemyAlive, enemyInventory, enemyAbilities, enemyPassives, enemyTags);
        return shadowImpaler;
    }
}
