package Items.Equipment.Weapons;

public class MagicWeapon extends Weapon {
    public MagicWeapon(String name, String description, int tier) {
        super(name, description,"Magic Weapon", tier);
        this.setMagic(calculateMainStat(tier));
        this.setStrength(calculateOffStat(tier));
    }
}
