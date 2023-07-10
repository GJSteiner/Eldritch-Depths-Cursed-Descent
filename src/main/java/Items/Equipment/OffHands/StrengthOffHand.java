package Items.Equipment.OffHands;

public class StrengthOffHand extends OffHand{
    public StrengthOffHand(String name, String description, int tier) {
        super(name, description, tier);
        this.setStrength(calculateMainStat(tier));
    }
}
