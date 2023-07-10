package Systems;

import Characters.Character;
import Items.Equipment.EquipableItem;
import Items.Equipment.EquipmentSlot;
import Items.Item;

import java.util.ArrayList;
import java.util.List;

public class EquipmentSystem {
    private List<EquipmentSlot> equipmentSlots;


    public EquipmentSystem() {
        equipmentSlots = new ArrayList<>();
        initializeEquipmentSlots();
    }

    private void initializeEquipmentSlots() {
        equipmentSlots = new ArrayList<>();
        equipmentSlots.add(EquipmentSlot.HEAD);
        equipmentSlots.add(EquipmentSlot.CHEST);
        equipmentSlots.add(EquipmentSlot.LEGS);
        equipmentSlots.add(EquipmentSlot.HANDS);
        equipmentSlots.add(EquipmentSlot.FEET);
        equipmentSlots.add(EquipmentSlot.WEAPON);
        equipmentSlots.add(EquipmentSlot.OFF_HAND);
    }

    public List<EquipmentSlot> getEquipmentSlots() {
        return equipmentSlots;
    }

    public void equipItem(Character character, Item item) {
        if (item instanceof EquipableItem) {
            EquipableItem equipableItem = (EquipableItem) item; // Type casting item as EquipableItem
            EquipmentSlot equipmentSlot = equipableItem.getEquipmentSlot();

            // Check if the equipment slot is already occupied
            if (isEquipmentSlotOccupied(character, equipmentSlot)) {
                character.unequip(equipmentSlot);
//                System.out.println("Cannot equip the item. The equipment slot " + equipmentSlot.getName() + " is already occupied.");
            }
                // Equip the item
                character.equip(equipableItem);
                equipmentSlots.add(equipmentSlot);

                character.getInventory().remove(item);
                System.out.println("Equipped " + item.getName() + " in " + equipmentSlot.getName() + " slot.");

        } else {
            System.out.println("Cannot equip the item. The item is not equipable.");
        }
    }
    public boolean isEquipmentSlotOccupied(Character character, EquipmentSlot equipmentSlot) {
        return character.getEquippedItems().containsKey(equipmentSlot) && character.getEquippedItems().get(equipmentSlot) != null;
    }
}
