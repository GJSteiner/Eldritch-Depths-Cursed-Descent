package Characters.Enemies;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Character;
import Items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Character {
    private int xpYield;
    private String enemyType;
    private String description;
    private List<String> enemyTags;
    public Enemy(){

    }

    public Enemy(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, int xpYield, String enemyType, String description, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> enemyTags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, inventory, abilities, passives);
        this.xpYield = xpYield;
        this.enemyType = enemyType;
        this.description = description;
        this.enemyTags = enemyTags;
    }

    public int getXpYield() {
        return xpYield;
    }

    public void setXpYield(int xpYield) {
        this.xpYield = xpYield;
    }

    public String getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(String enemyType) {
        this.enemyType = enemyType;
    }

    public List<String> getEnemyTags() {
        return enemyTags;
    }

    public void setEnemyTags(List<String> enemyTags) {
        this.enemyTags = enemyTags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int dropGold(){
        int minGold = 10*(getLevel()+1);
        int goldRange = 5*(getLevel()+1);
        int maxGold = minGold+goldRange;

        Random random = new Random();
        int droppedGold = random.nextInt(maxGold-minGold+1) + minGold;

        return droppedGold;
    }
}
