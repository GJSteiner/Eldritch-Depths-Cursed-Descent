package Items;

public class Potion extends Item{

    private int healthRestore;
    private int magicRestore;
    private int strengthBoost;
    private int maxHealthBoost;
    private int magicBoost;
    private int defenseBoost;

    public Potion(String name, String description, int healthRestore, int magicRestore) {
        super(name, description);
        this.healthRestore = healthRestore;
        this.magicRestore = magicRestore;
    }

    public Potion(String name, String description, int healthRestore, int magicRestore, int strengthBoost, int maxHealthBoost, int magicBoost, int defenseBoost) {
        super(name, description);

        this.healthRestore = healthRestore;
        this.magicRestore = magicRestore;
        this.strengthBoost = strengthBoost;
        this.maxHealthBoost = maxHealthBoost;
        this.magicBoost = magicBoost;
        this.defenseBoost = defenseBoost;
    }

    public int getHealthRestore() {
        return healthRestore;
    }

    public void setHealthRestore(int healthRestore) {
        this.healthRestore = healthRestore;
    }

    public int getMagicRestore() {
        return magicRestore;
    }

    public void setMagicRestore(int magicRestore) {
        this.magicRestore = magicRestore;
    }

    public int getStrengthBoost() {
        return strengthBoost;
    }

    public void setStrengthBoost(int strengthBoost) {
        this.strengthBoost = strengthBoost;
    }

    public int getMaxHealthBoost() {
        return maxHealthBoost;
    }

    public void setMaxHealthBoost(int maxHealthBoost) {
        this.maxHealthBoost = maxHealthBoost;
    }

    public int getMagicBoost() {
        return magicBoost;
    }

    public void setMagicBoost(int magicBoost) {
        this.magicBoost = magicBoost;
    }

    public int getDefenseBoost() {
        return defenseBoost;
    }

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }
}