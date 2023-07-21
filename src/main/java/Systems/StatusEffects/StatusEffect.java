package Systems.StatusEffects;

public abstract class StatusEffect {
    private String name;
    private int remainingRounds;
    private double intensity;
    private String tag;

    public StatusEffect(String name, String tag, int duration, double intensity) {
        this.name = name;
        this.tag = tag;
        this.remainingRounds = duration;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setRemainingRounds(int remainingRounds) {
        this.remainingRounds = remainingRounds;
    }

    public boolean isExpired() {
        return remainingRounds <= 0;
    }

    public String getTag() {
        return tag;
    }
    public void decrementRounds() {
        remainingRounds--;
    }

}
