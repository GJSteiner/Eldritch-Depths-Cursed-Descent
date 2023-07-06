package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public abstract class Feet extends Armor {
    public Feet(String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description, EquipmentSlot.FEET, magic, strength, defense, health);
    }
}
