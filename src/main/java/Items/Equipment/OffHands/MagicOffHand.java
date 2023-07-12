package Items.Equipment.OffHands;

public class MagicOffHand extends OffHand{
    public MagicOffHand(String name, String description, int tier) {
        super(name, description, "Magic Offhand", tier);
        this.setMagic(calculateMainStat(tier));
    }
}
