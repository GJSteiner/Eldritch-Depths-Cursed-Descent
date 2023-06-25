package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.abilities = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.passives = new ArrayList<>();
    }

    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.abilities = abilities;
        this.inventory = inventory;
        this.passives = passives;
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



}