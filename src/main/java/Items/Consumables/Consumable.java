package Items.Consumables;

import Items.Item;

public abstract class Consumable extends Item {
    private int quantity;
    public Consumable(String name, String description) {
        super(name, description);
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity(){
        return quantity;
    }

}
