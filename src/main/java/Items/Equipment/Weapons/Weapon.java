package Items.Equipment.Weapons;

import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;

public abstract class Weapon extends EquipableItem {
    public Weapon(String name, String description, String type, int tier) {
        super(name, description, EquipmentSlot.WEAPON, type, tier, 0, 0, 0, 0);
    }

    protected int calculateMainStat(int tier) {
        return calculateMainStat(tier, 10);
    }

    protected int calculateOffStat(int tier) {
        return calculateOffStat(tier, 10);
    }
    protected int calculateBalanceStat(int tier){
        return calculateBalanceStat(tier, 10);
    }
}
