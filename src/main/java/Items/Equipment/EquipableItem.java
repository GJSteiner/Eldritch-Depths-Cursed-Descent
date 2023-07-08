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
        // Running checks on all of these to make sure that if there is a debuff, it's not
        // dropped by unequipping and reequipping.
        if(defense > 0) {
            character.setDefense(character.getDefense() + defense);
        }
    }
    public void removeDefense(Character character){
        if(defense >0) {
            character.setDefense(character.getDefense() - defense);
        }
    }
    public void addHealth(Character character){
        if(health >0) {
            character.setMaxHealth(character.getMaxHealth() + health);
        }
    }
    public void removeHealth(Character character){
        if(health >0) {
            int currentHealth = character.getHealth();
            character.setMaxHealth(character.getMaxHealth() - health);
            if (currentHealth >= character.getMaxHealth()) {
                character.setHealth(character.getMaxHealth());
            } else {
                character.setHealth(currentHealth);
            }
        }
    }
    public void addStrength(Character character){
        if(strength > 0){
        character.setStrength(character.getStrength()+strength);
        }
    }
    public void removeStrength(Character character){
        if(strength > 0) {
            character.setStrength(character.getStrength() - strength);
        }
    }
    public void addMagic(Character character){
        if(magic > 0) {
            character.setMagic(character.getMagic() + magic);
        }
    }
    public void removeMagic(Character character) {
        if (magic > 0){
            character.setMagic(character.getMagic() - magic);
        }
    }
//    public abstract void applyEffect(Character character);
}
