package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Legs extends Armor{
    public Legs (String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description, EquipmentSlot.LEGS, magic, strength, defense, health);
    }
}
