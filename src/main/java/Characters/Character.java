package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Consumables.UsableItem;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;
import Systems.*;
import Systems.StatusEffects.Buff;
import Systems.StatusEffects.Debuff;
import Systems.StatusEffects.StatusEffect;

import java.util.*;

public abstract class Character {
   private String name = "";
   private int level = 1;
   private int maxHealth;
   private int baseHealth = maxHealth;
   private int equippedHealth = 0;
   private int health = 1;
   private int magic = 1;
   private int equippedMagic =0;
   private int baseMagic = magic;
   private int strength = 1;
   private int equippedStrength = 0;
   private int baseStrength = strength;
   private int defense = 1;
  private  int equippedDefense=0;
   private int baseDefense = defense;
  private  boolean alive = true;
  private  Ability lastAbility;


    protected List<Item> inventory;
    protected List<Ability> abilities;
    protected List<Passive> passives;
    private List<DamageOverTime> damageOverTimeEffects;
    private List<HealOverTime> healOverTimeEffects;
    private Map<EquipmentSlot, EquipableItem> equippedItems;
    private EquipmentSystem equipmentSystem;
    private List<Debuff> activeDebuffs;
    private List<Buff> activeBuffs;
    private List<StatusEffect> activeStatusEffects = new ArrayList<>();



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
        this.healOverTimeEffects = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.equipmentSystem = new EquipmentSystem();
        this.activeBuffs = new ArrayList<>();
        this.activeDebuffs = new ArrayList<>();

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
        this.healOverTimeEffects = new ArrayList<>();
        this.equippedItems = new HashMap<>();
        this.equipmentSystem = new EquipmentSystem();
        this.activeBuffs = new ArrayList<>();
        this.activeDebuffs = new ArrayList<>();
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

    public int getEquippedHealth() {
        return equippedHealth;
    }

    public Ability getLastAbility() {
        return lastAbility;
    }

    public void setLastAbility(Ability lastAbility) {
        this.lastAbility = lastAbility;
    }

    public void setEquippedHealth(int equippedHealth) {
        this.equippedHealth = equippedHealth;
        calculateTotalHealth();
    }
    public int calculateTotalHealth() {
        maxHealth = baseHealth + equippedHealth;
        for (Debuff debuff : activeDebuffs) {
            if (debuff.getTag().equals("Health")) {
                maxHealth -= debuff.getIntensity();
            }
        }
        for (Buff buff : activeBuffs){
            if (buff.getTag().equals("Health")){
                maxHealth += buff.getIntensity();
            }
        }
        return maxHealth;
    }

    public int getEquippedMagic() {
        return equippedMagic;
    }

    public void setEquippedMagic(int equippedMagic) {
        this.equippedMagic = equippedMagic;
        calculateTotalMagic();
    }

    public void calculateTotalMagic() {
        magic = baseMagic + equippedMagic;
        for (Debuff debuff : activeDebuffs) {
            if (debuff.getTag().equals("Magic")) {
                magic -= debuff.getIntensity();
            }
        }
        for (Buff buff : activeBuffs){
            if (buff.getTag().equals("Magic")){
                magic += buff.getIntensity();
            }
        }
    }

    public int getEquippedStrength() {
        return equippedStrength;
    }

    public void setEquippedStrength(int equippedStrength) {
        this.equippedStrength = equippedStrength;
        calculateTotalStrength();
    }
    public void calculateTotalStrength() {
        strength = baseStrength + equippedStrength;
        for (Debuff debuff : activeDebuffs) {
            if (debuff.getTag().equals("Strength")) {
                strength -= debuff.getIntensity();
            }
        }
        for (Buff buff : activeBuffs){
            if (buff.getTag().equals("Strength")){
                strength += buff.getIntensity();
            }
        }
    }

    public int getEquippedDefense() {
        return equippedDefense;
    }

    public void setEquippedDefense(int equippedDefense) {
        this.equippedDefense = equippedDefense;
        calculateTotalDefense();
    }
    public void calculateTotalDefense() {
        defense = baseDefense + equippedDefense;
        for (Debuff debuff : activeDebuffs) {
            if (debuff.getTag().equals("Defense")) {
                defense -= debuff.getIntensity();
            }
        }
        for (Buff buff : activeBuffs){
            if (buff.getTag().equals("Health")){
                defense += buff.getIntensity();
            }
        }
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

    public List<HealOverTime> getHealOverTimeEffects() {
        return healOverTimeEffects;
    }

    public void setHealOverTimeEffects(List<HealOverTime> healOverTimeEffects) {
        this.healOverTimeEffects = healOverTimeEffects;
    }

    public double takeDamage(double damage) {


        health -= getActualDamgage(damage);
        if(health <= 0){
            alive = false;
        }
        return getActualDamgage(damage);
    }
    public double getActualDamgage(double damage){
        double damageReduction = defense * 0.25;

        double reducedDamage = damage - damageReduction;
        if (reducedDamage < 0) {
            reducedDamage = 0;
        }
        return reducedDamage;
    }
    public void takeUnmitigatedDamage(double damage){
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
        System.out.println("Health: " + getHealth() + "/" + (maxHealth+equippedHealth) + " HP");
        System.out.println("Magic: " + getMagic());
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
    }
    public void applyHealOverTime(String hotName, double healthPerRound, int numRounds){
        HealOverTime existingHot = getExistingHealOverTimeEffects(hotName);
        if(existingHot != null){
            existingHot.setRemainingRounds(existingHot.getRemainingRounds() + numRounds);
        }
        else{
            HealOverTime hot = new HealOverTime(hotName, healthPerRound, numRounds);
            healOverTimeEffects.add(hot);
        }
    }

    public void applyDamageOverTime(String dotName, double damagePerRound, int numRounds, String dotElement, boolean stacking) {
        DamageOverTime existingDot = getExistingDamageOverTimeEffect(dotName);
        if(existingDot != null){

            //This stacks the duration
            existingDot.setRemainingRounds(existingDot.getRemainingRounds() + numRounds);
            if(stacking){
                //This stacks the intensity
                existingDot.setDamagePerRound(existingDot.getDamagePerRound() + damagePerRound);
            }
        }
        else {
            DamageOverTime dot = new DamageOverTime(dotName, damagePerRound, numRounds, dotElement, stacking);
            damageOverTimeEffects.add(dot);
        }
    }
    public HealOverTime getExistingHealOverTimeEffects(String hotName){
        for (HealOverTime hot : healOverTimeEffects){
            if(hot.getHotName().equals(hotName)){
                return hot;
            }
        }
        return null;
    }
    public DamageOverTime getExistingDamageOverTimeEffect(String dotName) {
        // Iterating over the damageOverTimeEffects list and checking if any effect already exists
        for (DamageOverTime dot : damageOverTimeEffects) {
            if (dot.getDotName().equals(dotName)) {
                return dot;
            }
        }
        return null;
    }

    public void updateHealOverTime(){
        Iterator<HealOverTime> iterator = healOverTimeEffects.iterator();
        while (iterator.hasNext()) {
            HealOverTime hot = iterator.next();
            double healing = hot.getHealthPerRound();
            heal(healing);

            hot.decrementRounds();
            if (hot.getRemainingRounds() <= 0) {
                iterator.remove();
            }
        }
    }

    public void updateDamageOverTime() {
        //Using an Iterator rather than a for loop so that dots that have expired can be removed without
        //interrupting the loop
        Iterator<DamageOverTime> iterator = damageOverTimeEffects.iterator();
        while (iterator.hasNext()) {
            DamageOverTime dot = iterator.next();
            double damage = dot.getDamagePerRound();
            takeUnmitigatedDamage(damage);

            dot.decrementRounds();
            if (dot.getRemainingRounds() <= 0) {
                iterator.remove();
            }
        }
    }
    public void removeAllDots(){
        for (DamageOverTime dot : getDamageOverTimeEffects()){
            dot.setRemainingRounds(0);
        }
        removeDamageOverTime();
    }
    public void removeAllHots(){
        for (HealOverTime hot : getHealOverTimeEffects()){
            hot.setRemainingRounds(0);
        }
        removeHealOverTime();
    }
    public void removeAllStatus(){
        for (StatusEffect status : getActiveStatusEffects()){
            status.setRemainingRounds(0);
        }
        removeAllStatusEffects();
    }
    public void removeDamageOverTime() {

        List<DamageOverTime> toRemove = new ArrayList<>();
        for (DamageOverTime dot : damageOverTimeEffects) {
            if (dot.getRemainingRounds() <= 0) {
                toRemove.add(dot);
            }
        }
        damageOverTimeEffects.removeAll(toRemove);
    }
    public void removeHealOverTime(){
        List<HealOverTime> toRemove = new ArrayList<>();

        for(HealOverTime hot : healOverTimeEffects){
            if (hot.getRemainingRounds() <= 0) {
                toRemove.add(hot);
            }
        }
        healOverTimeEffects.removeAll(toRemove);

    }
    public void equip(EquipableItem equipment) {
        EquipmentSlot equipmentSlot = equipment.getEquipmentSlot();

        // Check if the equipment slot is already occupied
//        if (equipmentSystem.isEquipmentSlotOccupied(this, equipmentSlot)) {
//            System.out.println("Cannot equip the item. The equipment slot " + equipmentSlot.getName() + " is already occupied.");
//            return;
//        }

        // Equip the item to the character
        equippedItems.put(equipmentSlot, equipment);

        // Apply the item's effects to the character
        equipment.addDefense(this);
        equipment.addHealth(this);
        equipment.addStrength(this);
        equipment.addMagic(this);

        updateStats();

        System.out.println("Equipped item: " + equipment.getName() + " to " + equipmentSlot.getName());
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

            updateStats();

            System.out.println("Unequipped " + unequippedItem.getName() + " from " + equipmentSlot.getName());
        } else {
            System.out.println("No item equipped in " + equipmentSlot.getName());
        }
    }
    public void unequipAll() {
        equippedItems.clear();
        updateStats();
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
    public void applyDebuff(Debuff debuff) {
        activeDebuffs.add(debuff);
        updateStats();
    }

    public void removeDebuff(Debuff debuff) {
        activeDebuffs.remove(debuff);
        updateStats();
    }public void applyBuff(Buff buff) {
        activeBuffs.add(buff);
        updateStats();
    }

    public void removeBuff(Buff buff) {
        activeBuffs.remove(buff);
        updateStats();
    }
    public void removeAllBuffs(){
        List<Buff> toRemove = new ArrayList<>();

        for (Buff buff : activeBuffs){
            if (buff.getRemainingRounds() <= 0) {
                toRemove.add(buff);
            }
        }
        getActiveBuffs().removeAll(toRemove);
    }


    public void removeAllDebuffs(){
        List<Debuff> toRemove = new ArrayList<>();

        for (Debuff debuff : activeDebuffs){
            if (debuff.getRemainingRounds() <= 0) {
                toRemove.add(debuff);
            }
        }
        getActiveDebuffs().removeAll(toRemove);
    }
    public void removeAllStatusEffects(){
        removeAllBuffs();
        removeAllDebuffs();
    }
    public void updateStats() {
        calculateTotalDefense();
        calculateTotalHealth();
        calculateTotalStrength();
        calculateTotalMagic();
    }

    public List<Debuff> getActiveDebuffs() {
        return activeDebuffs;
    }

    public List<Buff> getActiveBuffs() {
        return activeBuffs;
    }

    public List<StatusEffect> getActiveStatusEffects() {
        return activeStatusEffects;
    }
    public void applyStatusEffect(StatusEffect statusEffect) {
//        // Checking if the character is already affected by the same status effect
//        for (StatusEffect effect : activeStatusEffects) {
//            if (effect.getName().equals(statusEffect.getName())) {
//                // Update the duration if the effect is already active
//                effect.setDuration(statusEffect.getDuration());
//                return;
//            }
//        }
        activeStatusEffects.add(statusEffect);
    }
    public void updateStatusEffect() {

        Iterator<StatusEffect> iterator = activeStatusEffects.iterator();
        while (iterator.hasNext()) {
            StatusEffect statusEffect = iterator.next();
            statusEffect.decrementRounds();
            if (statusEffect.getRemainingRounds() <= 0) {
                iterator.remove();
            }
        }
    }
    public abstract void levelUp();
}