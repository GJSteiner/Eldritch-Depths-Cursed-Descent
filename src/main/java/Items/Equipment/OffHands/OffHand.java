package Items.Equipment.OffHands;

import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Equipment.Weapons.Weapon;

public class OffHand extends EquipableItem {
    public OffHand(String name, String description, int tier) {
        super(name, description, EquipmentSlot.OFF_HAND, tier, 0, 0, 0, 0);
    }

    protected int calculateMainStat(int tier) {
        return calculateMainStat(tier, 5);
    }
}
