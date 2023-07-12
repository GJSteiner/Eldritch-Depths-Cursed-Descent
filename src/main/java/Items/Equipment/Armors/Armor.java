package Items.Equipment.Armors;

import Characters.Character;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Armor extends EquipableItem {


    public Armor(String name, String description, EquipmentSlot equipmentSlot, String type, int tier) {
        super(name, description, equipmentSlot, type, tier,0,0,0,0);
    }

}