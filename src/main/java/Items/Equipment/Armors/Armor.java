package Items.Equipment.Armors;

import Characters.Character;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;

public abstract class Armor extends EquipableItem {
    public Armor(String name, String description, EquipmentSlot equipmentSlot, int tier) {
        super(name, description, equipmentSlot, tier,0,0,0,0);
    }

}