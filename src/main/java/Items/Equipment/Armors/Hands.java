package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public abstract class Hands extends Armor{
    public Hands(String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description, EquipmentSlot.HANDS, magic, strength, defense, health);
    }
}
