package Systems;

public class HealOverTime {
    private String hotName;
    private double healthPerRound;
    private int remainingRounds;

    public HealOverTime(String hotName, double healthPerRound, int remainingRounds){
        this.hotName = hotName;
        this.healthPerRound = healthPerRound;
        this.remainingRounds = remainingRounds;
    }

    public String getHotName() {
        return hotName;
    }

    public double getHealthPerRound() {
        return healthPerRound;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }
    public void decrementRounds() {
        remainingRounds--;
    }
    public void endHot(){
        remainingRounds = 0;
    }

    public void setHotName(String hotName) {
        this.hotName = hotName;
    }

    public void setHealthPerRound(double healthPerRound) {
        this.healthPerRound = healthPerRound;
    }

    public void setRemainingRounds(int remainingRounds) {
        this.remainingRounds = remainingRounds;
    }
}
