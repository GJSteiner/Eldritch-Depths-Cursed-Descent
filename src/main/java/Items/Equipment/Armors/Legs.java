package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Legs extends Armor{
    public Legs (String name, String description, int tier) {
        super(name, description, EquipmentSlot.LEGS, tier);
        this.setDefense(calculateMainStat(tier, 7));
        this.setHealth(calculateMainStat(tier, 35));
    }
}
