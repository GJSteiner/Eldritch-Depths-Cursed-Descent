package Items;

import Characters.Character;

public abstract class UsableItem extends Item {
    public UsableItem(String name, String description) {
        super(name, description);
    }

    public abstract void use(Character character);

}