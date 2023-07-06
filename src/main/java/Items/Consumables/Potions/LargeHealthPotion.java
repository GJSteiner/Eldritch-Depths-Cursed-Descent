package Items.Consumables.Potions;

public class LargeHealthPotion extends Potion {
    private static final String NAME = "Large Health Potion";
    private static final String DESCRIPTION = "A red potion that heals a large amount";
    private static final int HEALTH_RESTORE = 20;
    private static final int MAGIC_RESTORE = 0;

    public LargeHealthPotion() {
        super(NAME, DESCRIPTION, HEALTH_RESTORE, MAGIC_RESTORE);
    }
}
