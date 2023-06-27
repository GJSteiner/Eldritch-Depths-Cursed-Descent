package Items.Potions;

import Characters.Character;
import Items.Item;
import Items.Potion;

public class HealthPotions {

    public Potion mediumHealthPotion = new Potion("Medium Health Potion", "A red potion that heals a moderate amount", 10, 0);
    public Potion largeHealthPotion = new Potion("Large Health Potion", "A red potion that heals a large amount", 20, 0);

    public Potion createSmallHealthPotion(){
        Potion smallHealthPotion = new Potion("Small Health Potion", "A red potion that heals a small amount", 5, 0);
        return smallHealthPotion;
    }
    public void useHealthPotion(Character user, Potion potion){
        user.heal(potion.getHealthRestore());
    }

}
