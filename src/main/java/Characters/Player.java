package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Item;
import Rooms.Room;
import Systems.Direction;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private Room currentRoom;
    private int experience;
    private int gold;

    //shouldn't need these constructors anymore, since I moved them to the Character superclass
    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.abilities = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.passives = new ArrayList<>();
        this.gold = 0;
    }
//
//    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, List<Item> inventory, List<Ability> abilities, List<Passive> passives) {
//        super(name, level, maxHealth, health, magic, strength, defense, alive);
//        this.abilities = abilities;
//        this.inventory = inventory;
//        this.passives = passives;
//    }

    @Override
    public double magicAttack(int magic) {
        int damage = 0;
        return damage;
    }

    public double strengthAttack(int strength){
        int damage = 0;
        return damage;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    public void addGold(int amount){
        gold += amount;
    }
    public void subtractGold(int amount){
        gold -= amount;
    }

    public void move(Direction direction) {
        Room currentRoom = getCurrentRoom();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom != null) {
            setCurrentRoom(nextRoom);
            System.out.println("You move " + direction.toString() + " to the " + nextRoom.getName() + ".");

        } else {
            System.out.println("There is no exit in that direction.");
        }
    }

    public void gainExperience(int xp){
        experience += xp;
        System.out.println(getName() + " has earned " + xp + " experience!");
        levelUp();
    }

    private void levelUp(){
        int experienceThreshold = calculateExperienceThreshold();
        while(experience >= experienceThreshold){
            level++;
            System.out.println(getName() + " has leveled up!");
            System.out.println(getName() + " is now level " + level + "!");
            maxHealth *= (level+1);
            strength *= (level+1);
            magic *= (level+1);
            defense *= (level+1);
            experience = 0;
            displayCharacterStats();
            experienceThreshold = calculateExperienceThreshold();
        }
    }
    private int calculateExperienceThreshold(){
        int baseExperienceThreshold = 100;
        int thresholdIncrease = 50;
        int newExperienceTreshold = baseExperienceThreshold + (thresholdIncrease * (level));
        if(level == 0){
            return baseExperienceThreshold;
        }
        else {
            return newExperienceTreshold;
        }
    }

}