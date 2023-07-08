package Items.Equipment.Weapons;

import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;

public class Weapon extends EquipableItem {
    public Weapon(String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description, equipmentSlot, magic, strength, defense, health);
    }
}
