package Abilities;
import Characters.Character;

public abstract class Ability {
    private String name;
    private String description;
    private int levelRequirement;
    private double damage;
    private boolean aoe;

    public Ability(String name, String description, int levelRequirement, double damage, boolean aoe) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.damage = damage;
        this.aoe = aoe;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getLevelRequirement() {
        return levelRequirement;
    }

    public double getDamage() {
        return damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public boolean isAoe() {
        return aoe;
    }

    public void setAoe(boolean aoe) {
        this.aoe = aoe;
    }

    protected abstract void executeAbility(Character caster, Character target);

    public void useAbility(Character caster, Character target){
        if (caster.getLevel() >= levelRequirement){
            executeAbility(caster, target);
        }
        else {
            System.out.println("You have not reached the required level for this ability.");
        }
    };

}
