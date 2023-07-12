package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Hands extends Armor{
    public Hands(String name, String description, int tier) {
        super(name, description, EquipmentSlot.HANDS,"Hands", tier);
        this.setDefense(calculateMainStat(tier, 2));
        this.setHealth(calculateMainStat(tier, 10));
    }
}
