package Items.Equipment;

public class EquipmentSlot {

    public static final EquipmentSlot HEAD = new EquipmentSlot("Head");
    public static final EquipmentSlot CHEST = new EquipmentSlot("Chest");
    public static final EquipmentSlot LEGS = new EquipmentSlot("Legs");
    public static final EquipmentSlot HANDS = new EquipmentSlot("Hands");
    public static final EquipmentSlot FEET = new EquipmentSlot("Feet");
    public static final EquipmentSlot WEAPON = new EquipmentSlot("Weapon");
    public static final EquipmentSlot OFF_HAND = new EquipmentSlot("Off-Hand");

    private String name;

        public EquipmentSlot(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

}
