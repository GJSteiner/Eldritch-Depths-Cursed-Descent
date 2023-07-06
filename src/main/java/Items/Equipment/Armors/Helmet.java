package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public abstract class Helmet extends Armor {

    public Helmet(String name, String description, EquipmentSlot equipmentSlot, int magic, int strength, int defense, int health) {
        super(name, description, EquipmentSlot.HEAD, magic, strength, defense, health);
    }

}