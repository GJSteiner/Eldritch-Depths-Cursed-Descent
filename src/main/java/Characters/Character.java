package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Consumables.UsableItem;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;
import Systems.DamageOverTime;
import Systems.EquipmentSystem;

import java.util.*;

public abstract class Character {
    String name = "";
    int level = 1;
    int maxHealth;
    int baseHealth = maxHealth;
    int health = 1;
    int magic = 1;
    int baseMagic = magic;
    int strength = 1;
    int baseStrength = strength;
    int defense = 1;
    int baseDefense = defense;
    boolean alive = true;

    protected List<Item> inventory;
    protected List<Ability> abilities;
    protected List<Passive> passives;
    private List<DamageOverTime> damageOverTimeEffects;
    private Map<EquipmentSlot, EquipableItem> equippedItems;
    private EquipmentSystem equipmentSystem;



    public Character(){

    };



    public Character(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.health = health;
        this.magic = magic;
        this.strength = strength;
        this.defense = defense;
        this.alive = alive;
        this.abilities = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.passives = new ArrayList<>();
        this.damageOverTimeEffects = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.equipmentSystem = new EquipmentSystem();

    }

    public Character(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        this.name = name;
        this.level = level;
        this.maxHealth = maxHealth;
        this.health = health;
        this.magic = magic;
        this.strength = strength;
        this.defense = defense;
        this.alive = alive;
        this.abilities = abilities;
        this.inventory = inventory;
        this.passives = passives;
        this.damageOverTimeEffects = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.equipmentSystem = new EquipmentSystem();
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    double magicAttack(int magic) {
        return 0;
    }

    double strengthAttack(int strength) {
        return 0;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getBaseHealth() {
        return baseHealth;
    }

    public void setBaseHealth(int baseHealth) {
        this.baseHealth = baseHealth;
    }

    public int getBaseMagic() {
        return baseMagic;
    }

    public void setBaseMagic(int baseMagic) {
        this.baseMagic = baseMagic;
    }

    public int getBaseStrength() {
        return baseStrength;
    }

    public void setBaseStrength(int baseStrength) {
        this.baseStrength = baseStrength;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    public EquipmentSystem getEquipmentSystem() {
        return equipmentSystem;
    }

    public List<DamageOverTime> getDamageOverTimeEffects() {
        return damageOverTimeEffects;
    }

    public void setDamageOverTimeEffects(List<DamageOverTime> damageOverTimeEffects) {
        this.damageOverTimeEffects = damageOverTimeEffects;
    }

    public void takeDamage(double damage) {
        health -= damage;
        if(health <= 0){
            alive = false;
        }
    }
    public void heal(double healing){
        if(health+healing < maxHealth) {
            health += healing;
        }
        else {
            health = maxHealth;
        }
    }
    public List<Ability> getAbilities() {
        return abilities;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public List<Passive> getPassives() {
        return passives;
    }

    public void addAbility(Ability ability){
        abilities.add(ability);
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void addPassive(Passive passive){
        passives.add(passive);
    }
    public Map<EquipmentSlot, EquipableItem> getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(Map<EquipmentSlot, EquipableItem> equippedItems) {

        this.equippedItems = equippedItems;
    }
    public void displayCharacterStats() {
        System.out.println();
        System.out.println(getName() + ":");
        System.out.println("Level: " + getLevel());
        System.out.println("Health: " + getHealth() + "/" + maxHealth + " HP");
        System.out.println("Magic: " + getMagic());
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }


    public void applyDamageOverTime(String dotName, double damagePerRound, int numRounds) {
        DamageOverTime existingDot = getExistingDamageOverTimeEffect(dotName);
        if(existingDot != null){
            //This stacks the intensity
//            existingDot.setDamagePerRound(existingDot.getDamagePerRound() + damagePerRound);
            //This stacks the duration
            existingDot.setRemainingRounds(existingDot.getRemainingRounds() + numRounds);
        }
        else {
            DamageOverTime dot = new DamageOverTime(dotName, damagePerRound, numRounds);
            damageOverTimeEffects.add(dot);
        }
    }
    private DamageOverTime getExistingDamageOverTimeEffect(String dotName) {
        // Iterating over the damageOverTimeEffects list and checking if any effect already exists
        for (DamageOverTime dot : damageOverTimeEffects) {
            if (dot.getDotName().equals(dotName)) {
                return dot;
            }
        }
        return null; // No existing effect found
    }

    public void updateDamageOverTime() {
        //Using an Iterator rather than a for loop so that dots that have expired can be removed without
        //interrupting the loop
        Iterator<DamageOverTime> iterator = damageOverTimeEffects.iterator();
        while (iterator.hasNext()) {
            DamageOverTime dot = iterator.next();
            double damage = dot.getDamagePerRound();
            takeDamage(damage);

            dot.decrementRounds();
            if (dot.getRemainingRounds() <= 0) {
                iterator.remove();
            }
        }
    }
    public void equip(EquipableItem item) {
        EquipmentSlot equipmentSlot = item.getEquipmentSlot();

        // Check if the equipment slot is already occupied
//        if (equipmentSystem.isEquipmentSlotOccupied(this, equipmentSlot)) {
//            System.out.println("Cannot equip the item. The equipment slot " + equipmentSlot.getName() + " is already occupied.");
//            return;
//        }

        // Equip the item to the character
        equippedItems.put(equipmentSlot, item);

        // Apply the item's effects to the character
        item.addDefense(this);
        item.addHealth(this);
        item.addStrength(this);
        item.addMagic(this);

        System.out.println("Equipped item: " + item.getName() + " to " + equipmentSlot.getName());
    }
    public void unequip(EquipmentSlot equipmentSlot) {
        if (equipmentSystem.isEquipmentSlotOccupied(this, equipmentSlot)) {
            EquipableItem unequippedItem = equippedItems.get(equipmentSlot);
            equippedItems.remove(equipmentSlot);
            unequippedItem.removeDefense(this);
            unequippedItem.removeHealth(this);
            unequippedItem.removeStrength(this);
            unequippedItem.removeMagic(this);
            inventory.add(unequippedItem);
            System.out.println("Unequipped " + unequippedItem.getName() + " from " + equipmentSlot.getName());
        } else {
            System.out.println("No item equipped in " + equipmentSlot.getName());
        }
    }
    public void unequipAll() {
        equippedItems.clear();
//        System.out.println("All items have been unequipped.");
    }
    public boolean hasUsableItems(List<Item> inventory) {
        for (Item item : inventory) {
            if (item instanceof UsableItem) {
                return true;
            }
        }
        return false;
    }
    public void setBaseStats(){
        setBaseDefense(defense);
        setBaseHealth(health);
        setBaseMagic(magic);
        setBaseStrength(strength);
    }
}