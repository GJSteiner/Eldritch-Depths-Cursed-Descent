package Items.Equipment.Weapons;

public class StrengthWeapon extends Weapon {
    public StrengthWeapon(String name, String description, int tier) {
        super(name, description, tier);
        this.setStrength(calculateMainStat(tier));
        this.setMagic(calculateOffStat(tier));
    }
}
