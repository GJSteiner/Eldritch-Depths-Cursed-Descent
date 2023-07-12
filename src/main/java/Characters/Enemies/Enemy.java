package Characters.Enemies;

import Abilities.Ability;
import Abilities.Passive;
import Characters.Character;
import Items.Item;
import Systems.EnemyTags;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Enemy extends Character {
    EnemyTags tags = new EnemyTags();
    private int xpYield;
    private String enemyType;
    private String description;
    private List<String> enemyTags = new ArrayList<>();
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
        int adjustedXpYield = xpYield;
        if(enemyTags.contains(tags.getBossEnemy())){
            adjustedXpYield *= 2;
        }
         else if (enemyTags.contains(tags.getStrongEnemy())){
            adjustedXpYield *= 1.5;
        }
        else if(enemyTags.contains(tags.getMediumEnemy())){
            adjustedXpYield *= 1.25;
        }

        return adjustedXpYield;
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
        if(this.getEnemyTags().contains(tags.getMegaRichEnemy())){
            droppedGold*=3;
        }
        else if(this.getEnemyTags().contains(tags.getRichEnemy())){
            droppedGold*=2;
        }

        return droppedGold;
    }
    public Item dropRandomItem() {
        if (inventory.isEmpty()) {
            return null;
        }

        // Selecting a random item from the inventory
        int randomIndex = (int) (Math.random() * inventory.size());
        Item droppedItem = inventory.get(randomIndex);

        // Removing the dropped item from the inventory
        inventory.remove(randomIndex);

        return droppedItem;
    }
    public void addEnemyTag(String tag) {
        enemyTags.add(tag);
    }
    public void removeEnemyTag(String tag){
        enemyTags.remove(tag);
    }
}
