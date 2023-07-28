package Abilities;

public abstract class Passive {
    private String name;
    private String description;
    private int levelRequirement;

    public Passive(String name, String description, int levelRequirement) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }
}
