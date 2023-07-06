package Items.Equipment;

import Characters.Character;
import Characters.Player;
import Items.Item;

public abstract class EquipableItem extends Item {
    private EquipmentSlot equipmentSlot;
    private int magic;
    private int strength;
    private int defense;
    private int health;

    public EquipableItem(String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description);
        this.equipmentSlot = equipmentSlot;
        this.magic = magic;
        this.strength = strength;
        this.defense = defense;
        this.health = health;
    }

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

    // Moved these to player instead
//    public abstract void equip(Character character);
//
//    public abstract void unequip(Character character);
    public void addDefense(Character character){
        character.setDefense(character.getDefense()+defense);
    }
    public void removeDefense(Character character){
        character.setDefense(character.getDefense()-defense);
    }
    public void addHealth(Character character){
        character.setMaxHealth(character.getMaxHealth()+health);
        character.setHealth(character.getMaxHealth());
    }
    public void removeHealth(Character character){
        int currentHealth = character.getHealth();
        character.setMaxHealth(character.getMaxHealth()-health);
        if(currentHealth >= character.getMaxHealth()) {
            character.setHealth(character.getMaxHealth());
        }
        else{
            character.setHealth(currentHealth);
        }
    }
//    public abstract void applyEffect(Character character);
}
