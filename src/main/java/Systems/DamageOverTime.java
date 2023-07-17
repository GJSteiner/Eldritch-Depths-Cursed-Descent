package Systems;

public class DamageOverTime {
    private String dotName;
    private double damagePerRound;
    private int remainingRounds;
    private boolean stacking;
    private String element;


    public DamageOverTime(String dotName, double damagePerRound, int numRounds, String element) {
        this.dotName = dotName;
        this.damagePerRound = damagePerRound;
        this.remainingRounds = numRounds;
        this.element = element;
        this.stacking = false;
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

    public boolean isStacking() {
        return stacking;
    }

    public void setStacking(boolean stacking) {
        this.stacking = stacking;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
