package Characters;

import Dungeons.Floors.FloorLayout;
import Items.Consumables.Potions.Potion;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;
import Items.Consumables.UsableItem;
import Dungeons.Rooms.Room;
import Systems.Direction;


import java.util.*;

import static Systems.GameRunner.dungeon;

public class Player extends Character {

    private Room currentRoom;
    private FloorLayout currentFloor;
    private int experience;
    private int gold;
    private String playerClass;
   private int experienceThreshold = 100;

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
    public void displayPlayerStats(){
        System.out.println();
        System.out.println(getName() + ":");
        System.out.println("Level: " + getLevel());
        System.out.println("Experience: " + getExperience() + "/" + experienceThreshold);
        System.out.println("Health: " + getHealth() + "/" + getMaxHealth() + " HP");
        System.out.println("Magic: " + getMagic());
        System.out.println("Strength: " + getStrength());
        System.out.println("Defense: " + getDefense());
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

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public FloorLayout getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(FloorLayout currentFloor) {
        this.currentFloor = currentFloor;
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

    public int getExperienceThreshold() {
        return experienceThreshold;
    }

    public void setExperienceThreshold(int experienceTreshold) {
        this.experienceThreshold = experienceTreshold;
    }

    public void move() {
        Scanner scanner = new Scanner(System.in);
        List<Direction> availableDirections = currentRoom.getAvailableExits();
        boolean validDirection = false;
        while (!validDirection) {
            System.out.println();
            System.out.println("Where would you like to go?");

            for (Direction availableDirection : availableDirections) {
                Room availableRoom = currentRoom.getExit(availableDirection);
                System.out.println(availableDirection.toString() + ": " + availableRoom.getName());
            }

            String choice = scanner.nextLine();
            Direction chosenDirection = Direction.fromString(choice);

            if (chosenDirection != null && availableDirections.contains(chosenDirection)) {
                Room nextRoom = currentRoom.getExit(chosenDirection);
//                if (currentRoom.isEndRoom()) {
//                     int currentFloorIndex = dungeon.getCurrentFloorIndex();
//                       int nextFloorIndex = currentFloorIndex + 1;
//                }
                currentRoom = nextRoom;

                currentRoom.enterRoom(this); // Update the current room
                validDirection = true;


            } else {
                System.out.println("Invalid direction. Please choose one of the available directions.");
            }
        }
    }


    public void makeChoice(){
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Move");
        System.out.println("2. Check Inventory");
        System.out.println("3. Check Stats");
        System.out.println("4. Check Equipment");

        int choice = getActionChoice();

        if (choice == 1){
            move();
        }

        if (choice == 2) {
            displayInventoryAndChooseAction();
            makeChoice();
        }
        if (choice == 3) {
            displayPlayerStats();
            makeChoice();
        }
        if (choice == 4){
            displayEquipment();
            makeChoice();
        }

    }
    public int getActionChoice(){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean validChoice = false;

        while(!validChoice){
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                if(choice >=1 && choice <=4) {
                    validChoice = true;
                }
                else {
                    System.out.println("Invalid input. Please enter a number between 1 and 4.");
                }
            }
            else{
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        return choice;
    }

    public void gainExperience(int xp){
        experience += xp;
        System.out.println(getName() + " has earned " + xp + " experience!");
        levelUp();
    }

    @Override
    public void levelUp(){
//        int experienceThreshold = calculateExperienceThreshold();
        while(experience >= experienceThreshold){
            setLevel(getLevel()+1);
            System.out.println(getName() + " has leveled up!");
            System.out.println(getName() + " is now level " + getLevel() + "!");
            System.out.println();
//            Map<EquipmentSlot, EquipableItem> currentEquipment = getEquippedItems();
//            unequipAll();

            int newBaseHealth = (int)(getBaseHealth() * 1.5);
            int newBaseStrength = (int)(getBaseStrength() * 1.5);
            int newBaseMagic = (int)(getBaseMagic() * 1.5);
            int newBaseDefense = (int)(getBaseDefense() * 1.5);
            experience -= experienceThreshold;
            //could remove to allow excess xp to rollover after levelup
            if (experience < 0){
                experience = 0;
            }
            System.out.println("Max Health: " + getBaseHealth() + " -> " + newBaseHealth);
            System.out.println("Magic: " + getBaseMagic() + " -> " + newBaseMagic);
            System.out.println("Strength: " + getBaseStrength() + " -> " + newBaseStrength);
            System.out.println("Defense: " + getBaseDefense() + " -> " + newBaseDefense);

            setBaseHealth(newBaseHealth);
            calculateTotalHealth();

            int missingHealth = getMaxHealth() - getHealth();
            setHealth(getHealth()+(missingHealth/2));
            setBaseStrength(newBaseStrength);
            calculateTotalStrength();
            setBaseDefense(newBaseDefense);
            calculateTotalDefense();
            setBaseMagic(newBaseMagic);
            calculateTotalMagic();
//            displayCharacterStats();
//            for (EquipableItem item : currentEquipment.values()) {
//                if (item != null) {
//                    equip(item);
//                }
//            }

            experienceThreshold = calculateExperienceThreshold();
        }
    }
    public int calculateExperienceThreshold(){
//        int thresholdIncrease = 50;
//        int newExperienceTreshold = baseExperienceThreshold + (thresholdIncrease * (getLevel()));
        int thresholdIncrease = 2;
        experienceThreshold = experienceThreshold*thresholdIncrease;

//        if(getLevel() == 0){
            return experienceThreshold;
//        }
//        else {
//            return newExperienceTreshold;
//        }
    }
    public void displayEquipment(){
        System.out.println();
        System.out.println("Equipped Items:");
        System.out.println();

        for (Map.Entry<EquipmentSlot, EquipableItem> entry : getEquippedItems().entrySet()) {
            EquipmentSlot slot = entry.getKey();
            EquipableItem item = entry.getValue();

            System.out.println(slot.getName() + ": " + (item != null ? item.getName() : "Empty"));

            if(item != null){
                item.displayStats();
            }
            System.out.println();
        }
    }

    public void displayInventoryAndChooseAction() {
        System.out.println();
        System.out.println("=== Inventory ===");
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);
            System.out.println((i + 1) + ". " + item.getName());
        }
        System.out.println("0. Cancel");
        System.out.print("Enter the number of the item you want to use or equip: ");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 0) {
            System.out.println("Action canceled.");
            return;
        }

        int itemIndex = choice - 1;
        if (itemIndex >= 0 && itemIndex < inventory.size()) {
            Item selectedItem = inventory.get(itemIndex);
            if(selectedItem instanceof EquipableItem){
                ((EquipableItem) selectedItem).displayInfo();
                if(getEquipmentSystem().isEquipmentSlotOccupied(this, ((EquipableItem) selectedItem).getEquipmentSlot())){
                    EquipableItem equippedItem = getEquippedItems().get(((EquipableItem) selectedItem).getEquipmentSlot());
                    System.out.println();
                    System.out.println(this.getName() + " currently has " + equippedItem.getName() + " equipped in that slot.");
                    equippedItem.displayStats();
                }
            }
            else if (selectedItem instanceof Potion){
                System.out.println("Selected item: " + selectedItem.getName());

                System.out.println("Healing: " + ((Potion) selectedItem).getHealthRestore());
            }
            System.out.println();
            System.out.println("What action do you want to perform?");
            System.out.println("1. Use");
            System.out.println("2. Equip");
            System.out.println("0. Cancel");
            System.out.print("Enter your choice: ");
            System.out.println();

            int actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    // Use the item
                    if (selectedItem instanceof UsableItem) {
                        UsableItem usableItem = (UsableItem) selectedItem;
                        usableItem.use(this);
                            //don't need this line because in the Potion.use() method it already removes the potion
                            //from the inventory
                        //inventory.remove(selectedItem);
                    } else {
                        System.out.println("The selected item is not usable.");
                    }
                    break;
                case 2:
                    // Equip the item
                    getEquipmentSystem().equipItem(this, selectedItem);
                    break;
                case 0:
                    System.out.println("Action canceled.");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("Invalid item selection.");
        }
    }
    public void reset() {
        setHealth(20);
        setExperience(0);
        setLevel(0);
        setGold(0);
        getInventory().clear();
    }
}