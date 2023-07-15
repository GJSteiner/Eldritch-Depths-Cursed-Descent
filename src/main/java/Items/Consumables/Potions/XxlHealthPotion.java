package Items.Consumables.Potions;

public class XxlHealthPotion extends Potion{
    private static final String NAME = "XXL Health Potion";
    private static final String DESCRIPTION = "A red potion that heals a massive amount";
    private static final int HEALTH_RESTORE = 240;
    private static final int MAGIC_RESTORE = 0;

    public XxlHealthPotion() {
        super(NAME, DESCRIPTION, HEALTH_RESTORE, MAGIC_RESTORE);
    }

}
