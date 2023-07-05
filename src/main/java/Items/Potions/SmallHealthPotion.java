package Items.Potions;

import Characters.Character;
import Items.Potion;

public class SmallHealthPotion extends Potion {
    private static final String NAME = "Small Health Potion";
    private static final String DESCRIPTION = "A red potion that heals a small amount";
    private static final int HEALTH_RESTORE = 5;
    private static final int MAGIC_RESTORE = 0;

    public SmallHealthPotion() {
        super(NAME, DESCRIPTION, HEALTH_RESTORE, MAGIC_RESTORE);
    }

}
