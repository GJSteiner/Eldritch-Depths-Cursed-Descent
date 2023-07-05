package Abilities;
import Characters.Character;

public abstract class Ability {
    private String name;
    private String description;
    private int levelRequirement;
    private double damage;
    private boolean aoe;
    private boolean dot;
    private String abilityElement;

    public Ability(String name, String description, int levelRequirement, double damage, boolean aoe, boolean dot, String abilityElement) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.damage = damage;
        this.aoe = aoe;
        this.dot = dot;
        this.abilityElement = abilityElement;
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

    public boolean isDot() {
        return dot;
    }

    public void setDot(boolean dot) {
        this.dot = dot;
    }

    public String getAbilityElement() {
        return abilityElement;
    }

    public void setAbilityElement(String abilityElement) {
        this.abilityElement = abilityElement;
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
