package Items.Equipment.OffHands;

import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Equipment.Weapons.Weapon;

public abstract class OffHand extends EquipableItem {
    public OffHand(String name, String description, String type, int tier) {
        super(name, description, EquipmentSlot.OFF_HAND, type, tier, 0, 0, 0, 0);
    }

    protected int calculateMainStat(int tier) {
        return calculateMainStat(tier, 5);
    }
}
