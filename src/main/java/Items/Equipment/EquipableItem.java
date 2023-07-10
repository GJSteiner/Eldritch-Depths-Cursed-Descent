package Items.Equipment;

import Characters.Character;
import Characters.Player;
import Items.Item;
import org.apache.velocity.runtime.directive.Parse;

public abstract class EquipableItem extends Item {
    private int tier;
    private EquipmentSlot equipmentSlot;
    private int magic;
    private int strength;
    private int defense;
    private int health;

    public EquipableItem(String name, String description, EquipmentSlot equipmentSlot, int tier, int magic, int strength, int defense, int health) {
        super(name, description);
        this.tier = tier;
        this.equipmentSlot = equipmentSlot;
        this.magic = magic;
        this.strength = strength;
        this.defense = defense;
        this.health = health;
    }

//    public EquipableItem(String name, String description) {
//        super(name, description);
//    }

    public EquipmentSlot getEquipmentSlot() {
        return equipmentSlot;
    }

    public int getDefense() {
        return defense;
    }

    public int getHealth() {
        return health;
    }

    public int getMagic() {
        return magic;
    }

    public int getStrength() {
        return strength;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Moved these to player instead
//    public abstract void equip(Character character);
//
//    public abstract void unequip(Character character);
    public void addDefense(Character character) {
        // Running checks on all of these to make sure that if there is a debuff, it's not
        // dropped by unequipping and reequipping.
        if (defense > 0) {
            character.setEquippedDefense(character.getEquippedDefense() + defense);
        }
    }

    public void removeDefense(Character character) {
        if (defense > 0) {
            character.setEquippedDefense(character.getEquippedDefense() - defense);
        }
    }

    public void addHealth(Character character) {
        if (health > 0) {
            character.setEquippedHealth(character.getEquippedHealth() + health);
        }
    }

    public void removeHealth(Character character) {
        character.setEquippedHealth(character.getEquippedHealth() -health);
        if(character.getHealth() <=0){
            character.setHealth(1);
        }
    }

    public void addStrength(Character character) {
        if (strength > 0) {
            character.setEquippedStrength(character.getEquippedStrength() + strength);
        }
    }

    public void removeStrength(Character character) {
        if (strength > 0) {
            character.setEquippedStrength(character.getEquippedStrength() - strength);
        }
    }

    public void addMagic(Character character) {
        if (magic > 0) {
            character.setEquippedMagic(character.getEquippedMagic() + magic);
        }
    }

    public void removeMagic(Character character) {
        if (magic > 0) {
            character.setEquippedMagic(character.getEquippedMagic() - magic);
        }
    }

    protected static int calculateMainStat(int tier, int baseStat) {
        int mainStat = 0;
        switch (tier) {
            case 1:
                mainStat = baseStat;
                break;
            case 2:
                mainStat = baseStat * 2;
                break;
            case 3:
                mainStat = baseStat * 4;
                break;
            case 4:
                mainStat = baseStat * 7;
                break;
            case 5:
                mainStat = baseStat * 11;
                break;
            default:
                // Handling unknown tiers
                break;
        }
        return mainStat;
    }

    protected static int calculateOffStat(int tier, int baseStat) {
        int offStat = 0;
        if (calculateMainStat(tier, baseStat) % 2 == 1) {
            offStat = (calculateMainStat(tier, baseStat) + 1) / 2;
        } else {
            offStat = calculateMainStat(tier, baseStat) / 2;
        }
        return offStat;
    }

    protected static int calculateBalanceStat(int tier, int baseStat) {
        double balanceStat = calculateMainStat(tier, baseStat) * .75;
        int parsedBalanceStat = (int) balanceStat;
        return parsedBalanceStat;
    }


//    public abstract void applyEffect(Character character);
}
