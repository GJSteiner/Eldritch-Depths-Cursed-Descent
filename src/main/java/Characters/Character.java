package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    String name = "";
    int level = 1;
    int maxHealth;
    int health = 1;
    int magic = 1;
    int strength = 1;
    int defense = 1;
    boolean alive = true;

    protected List<Item> inventory;
    protected List<Ability> abilities;
    protected List<Passive> passives;

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
}