package Items.Equipment;

import Items.Item;

public class Weapon extends Item {
    private int magicBonus;
    private int strengthBonus;

    public Weapon(String name, String description, int magicBonus, int strengthBonus) {
        super(name, description);
        this.magicBonus = magicBonus;
        this.strengthBonus = strengthBonus;
    }

    // don't need because we're inheriting from the Item interface
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }

    public int getMagicBonus() {
        return magicBonus;
    }

    public int getStrengthBonus() {
        return strengthBonus;
    }
}
