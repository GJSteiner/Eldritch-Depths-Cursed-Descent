package Items.Equipment.OffHands;

public class DefenseOffHand extends OffHand{
    public DefenseOffHand(String name, String description, int tier) {
        super(name, description, tier);
        this.setDefense(calculateMainStat(tier));
    }
}
