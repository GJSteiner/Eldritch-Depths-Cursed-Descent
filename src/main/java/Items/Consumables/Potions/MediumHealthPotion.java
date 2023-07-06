package Items.Consumables.Potions;

public class MediumHealthPotion extends Potion {
    private static final String NAME = "Medium Health Potion";
    private static final String DESCRIPTION = "A red potion that heals a medium amount";
    private static final int HEALTH_RESTORE = 10;
    private static final int MAGIC_RESTORE = 0;

    public MediumHealthPotion() {
        super(NAME, DESCRIPTION, HEALTH_RESTORE, MAGIC_RESTORE);
    }
}
