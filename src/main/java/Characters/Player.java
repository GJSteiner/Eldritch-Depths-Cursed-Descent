package Characters;

import Abilities.Ability;
import Abilities.Passive;
import Items.Item;
import Rooms.Room;
import Systems.Direction;
import Dungeons.Dungeon;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Character {

    private Room currentRoom;
    private int experience;
    private int gold;
    private String playerClass;

    //shouldn't need these constructors anymore, since I moved them to the Character superclass
    public Player(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive) {
        super(name, level, maxHealth, health, magic, strength, defense, alive);
        this.abilities = new ArrayList<>();
        this.inventory = new ArrayList<>();
        this.passives = new ArrayList<>();
        this.gold = 0;
        this.playerClass = "Acolyte";
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

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        List<Direction> availableDirections = currentRoom.getAvailableExits();


        while(true) {
            System.out.println("Where would you like to go?");


            for(Direction availableDirection : availableDirections){
                Room availableRoom = currentRoom.getExit(availableDirection);
                System.out.println(availableDirection.toString() + ": " + availableRoom.getName());
            }

            String choice = scanner.nextLine();
            Direction chosenDirection = Direction.fromString(choice);

            if(chosenDirection != null && availableDirections.contains(chosenDirection)){
                Room nextRoom = currentRoom.getExit(chosenDirection);
                currentRoom = nextRoom;
                currentRoom.enterRoom(this);
                break;
            }else {
                System.out.println("Invalid direction. Please choose one of the available directions.");
            }

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
            System.out.println();
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