package Items.Consumables.Potions;

public class XlHealthPotion extends Potion{
    private static final String NAME = "XL Health Potion";
    private static final String DESCRIPTION = "A red potion that heals a huge amount";
    private static final int HEALTH_RESTORE = 120;
    private static final int MAGIC_RESTORE = 0;

    public XlHealthPotion() {
        super(NAME, DESCRIPTION, HEALTH_RESTORE, MAGIC_RESTORE);
    }

}
