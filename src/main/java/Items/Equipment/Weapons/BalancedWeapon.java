package Items.Equipment.Weapons;

import Items.Equipment.EquipmentSlot;

public class BalancedWeapon extends Weapon{
    public BalancedWeapon(String name, String description, int tier) {
        super(name, description, tier);
        this.setMagic(calculateBalanceStat(tier));
        this.setStrength(calculateBalanceStat(tier));
    }

}
