package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Chest extends Armor {
    public Chest(String name, String description, int tier) {
        super(name, description, EquipmentSlot.CHEST,"Chest", tier);
        this.setDefense(calculateMainStat(tier, 7));
        this.setHealth(calculateMainStat(tier, 35));
    }
}
