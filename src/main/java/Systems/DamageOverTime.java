package Systems;

public class DamageOverTime {
    private String dotName;
    private double damagePerRound;
    private int remainingRounds;

    public DamageOverTime(String dotName, double damagePerRound, int numRounds) {
        this.dotName = dotName;
        this.damagePerRound = damagePerRound;
        this.remainingRounds = numRounds;
    }

    public double getDamagePerRound() {
        return damagePerRound;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public void decrementRounds() {
        remainingRounds--;
    }
    public void endDot(){
        remainingRounds = 0;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public void setDamagePerRound(double damagePerRound) {
        this.damagePerRound = damagePerRound;
    }

    public void setRemainingRounds(int remainingRounds) {
        this.remainingRounds = remainingRounds;
    }
}
