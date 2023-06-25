package Characters;

import Abilities.Ability;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private List<Item> inventory;
    private List<Ability> abilities;

    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.abilities = new ArrayList<>();
        this.inventory = new ArrayList<>();
    }

    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.inventory = inventory;
        this.abilities = abilities;
    }

//    public Player(String name, int health, int magic, int strength, int defense, boolean alive) {
//        this.name = name;
//        this.health = health;
//        this.magic = magic;
//        this.strength = strength;
//        this.defense = defense;
//        this.inventory = new ArrayList<>();
//        this.abilities = new ArrayList<>();
//        this.alive = alive;
//    }

    public List<Item> getInventory() {
        return inventory;
    }

    @Override
    public double magicAttack(int magic) {
        int damage = 0;
        return damage;
    }

    public double strengthAttack(int strength){
        int damage = 0;
        return damage;
    }

    @Override
    public List<Ability> getAbilities() {

        return null;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public void addAbility(Ability ability){
        abilities.add(ability);
    }

}