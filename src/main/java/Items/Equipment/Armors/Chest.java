package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Chest extends Armor {
    public Chest(String name, String description, EquipmentSlot equipmentSlot,int magic, int strength, int defense, int health) {
        super(name, description, EquipmentSlot.CHEST, magic, strength, defense, health);
    }
}
