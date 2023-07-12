package Systems;

public abstract class StatusEffect {
    private String name;
    private int duration;
    private double intensity;
    private String tag;

    public StatusEffect(String name, String tag, int duration, double intensity) {
        this.name = name;
        this.tag = tag;
        this.duration = duration;
        this.intensity = intensity;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public double getIntensity() {
        return intensity;
    }

    public void decrementDuration() {
        duration--;
    }

    public boolean isExpired() {
        return duration <= 0;
    }

    public String getTag() {
        return tag;
    }

}
