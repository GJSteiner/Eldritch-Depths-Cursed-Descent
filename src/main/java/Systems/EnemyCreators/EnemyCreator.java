package Systems.EnemyCreators;

import Abilities.Ability;
import Abilities.Enemies.EnemyAbilities.*;
import Abilities.Enemies.EnemyPassives.CallOfTheVoid;
import Abilities.Enemies.EnemyPassives.Expunge;
import Abilities.Enemies.EnemyPassives.HighWaters;
import Abilities.Enemies.EnemyPassives.VoidVenom;
import Abilities.Passive;
import Characters.Enemies.Enemy;
import Items.Consumables.Potions.*;
import Items.Equipment.Armors.*;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
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

public abstract class EnemyCreator {

    //abilities
    protected final Ability darkBlast = new DarkBlast();
    protected final Ability voidSiphon = new VoidSiphon();
    protected final Ability voidDrain = new VoidDrain();
    protected final Ability shadowStep = new ShadowStep();
    protected final Ability impFire = new ImpFire();
    protected final Ability shadowEmbrace = new ShadowEmbrace();
    protected final Ability abyssalMaw = new AbyssalMaw();
    protected final Ability voidFire = new VoidFire();
    protected final Ability viciousBite = new ViciousBite();
    protected final Ability hellBlitz = new HellBlitz();
    protected final Ability abyssalTides = new AbyssalTides();
    protected final Ability voidSlash = new VoidSlash();

    // passives
    protected final Passive expunge = new Expunge();
    protected final Passive voidVenom = new VoidVenom();
    protected final Passive callOfTheVoid = new CallOfTheVoid();
    protected final Passive highWaters = new HighWaters();

    //add private final Ability lines for every enemy ability

    EnemyTags allTags = new EnemyTags();
    protected List<String> tags = new ArrayList<>();
    List<Ability> enemyAbilities = new ArrayList<>();
    List<Passive> enemyPassives = new ArrayList<>();
    SmallHealthPotion weakPotion = new SmallHealthPotion();
    MediumHealthPotion averagePotion = new MediumHealthPotion();
    LargeHealthPotion strongPotion = new LargeHealthPotion();
    XlHealthPotion veryStrongPotion = new XlHealthPotion();
    XxlHealthPotion extremelyStrongPotion = new XxlHealthPotion();
    ArmorList armorList = new ArmorList();
    WeaponList weaponList = new WeaponList();
    protected List<Item> enemyInventory = new ArrayList<>();
    public void createArmor(String type, int tier) {
        EquipableItem item = armorList.getByTypeAndTier(type, tier);
        if (item != null) {
            enemyInventory.add(item);
        }
    }
    public void createWeapon(String type, int tier){
        EquipableItem item = weaponList.getByTypeAndTier(type, tier);
        if(item != null){
            enemyInventory.add(item);
        }
    }

    protected ArmorList getArmorList() {
        return armorList;
    }


    protected WeaponList getWeaponList() {
        return weaponList;
    }
    public abstract Enemy create(String enemyName, int enemyLevel);

    }
