package Items.Equipment.Armors;

import Items.Equipment.EquipmentSlot;

public class Helmet extends Armor {

    public Helmet(String name, String description, int tier) {
        super(name, description, EquipmentSlot.HEAD,"Helmet", tier);
        this.setDefense(calculateMainStat(tier, 2));
        this.setHealth(calculateMainStat(tier, 10));
    }

}