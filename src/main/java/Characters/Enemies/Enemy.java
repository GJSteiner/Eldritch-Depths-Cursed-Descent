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
    protected static EnemyTags allTags = new EnemyTags();
    private int xpYield;
    private String enemyType;
    private String description;
    private static List<String> tags = new ArrayList<>();
    public Enemy(){

    }

    public Enemy(String name, int level, int maxHealth, int health, int magic, int strength, int defense, boolean alive, int xpYield, String enemyType, String description, List<Item> inventory, List<Ability> abilities, List<Passive> passives, List<String> tags) {
        super(name, level, maxHealth, health, magic, strength, defense, alive, inventory, abilities, passives);
        this.xpYield = xpYield;
        this.enemyType = enemyType;
        this.description = description;
        this.tags = tags;
    }

//    public int getXpYield() {
//        int adjustedXpYield = xpYield;
//        if(tags.contains(allTags.getBossEnemy())){
//            adjustedXpYield *= 2;
//        }
//         else if (tags.contains(allTags.getStrongEnemy())){
//            adjustedXpYield *= 1.5;
//        }
//        else if(tags.contains(allTags.getMediumEnemy())){
//            adjustedXpYield *= 1.25;
//        }
//
//        return adjustedXpYield;
//    }
public int getXpYield(int level) {
    int adjustedXpYield = xpYield;
    double levelAdjustment = 1.0;

    for (int i = 0; i < level; i++) {
        levelAdjustment += 1;
    }

    if (level > 0) {
        adjustedXpYield *= levelAdjustment;
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
        return tags;
    }

    public void setEnemyTags(List<String> enemyTags) {
        this.tags = enemyTags;
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
        if(this.getEnemyTags().contains(allTags.getMegaRichEnemy())){
            droppedGold*=3;
        }
        else if(this.getEnemyTags().contains(allTags.getRichEnemy())){
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
        tags.add(tag);
    }
    public void removeEnemyTag(String tag){
        tags.remove(tag);
    }
}
