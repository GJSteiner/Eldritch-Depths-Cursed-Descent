package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Feet extends Armor {
    public Feet(String name, String description, int tier) {
        super(name, description, EquipmentSlot.FEET, tier);
        this.setDefense(calculateMainStat(tier, 2));
        this.setHealth(calculateMainStat(tier, 10));
    }
}
