package Abilities;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.ArrayList;
import java.util.List;

public abstract class Ability {
    private String name;
    private String description;
    private List<String> tags;
    private int levelRequirement;
    private double damage;
    private boolean aoe;
    private boolean dot;
    private String abilityElement;
    private List<Enemy> summons = new ArrayList();


    public Ability(String name, String description, int levelRequirement, double damage, boolean aoe, boolean dot, String abilityElement) {
        this.name = name;
        this.description = description;
        this.levelRequirement = levelRequirement;
        this.damage = damage;
        this.aoe = aoe;
        this.dot = dot;
        this.abilityElement = abilityElement;
        this.tags = new ArrayList<>();
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

    public List<Enemy> getSummons() {
        return summons;
    }

    public void setSummons(List<Enemy> summons) {
        this.summons = summons;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    protected abstract void executeAbility(Character caster, Character target);
    protected abstract void executeAbilityAoe(Character caster, List<Enemy> targets);

    public void useAbility(Character caster, Character target){
        if (caster.getLevel() >= levelRequirement){
            executeAbility(caster, target);
        }
        else {
            System.out.println("You have not reached the required level for this ability.");
        }
        caster.setLastAbility(this);
    };
    public void useAbilityAoe(Character caster, List<Enemy> targets) {
        if (caster.getLevel() >= levelRequirement) {
            if (aoe) {
                executeAbilityAoe(caster, targets);
            } else {
                System.out.println("This ability cannot target multiple enemies. Use useAbility instead.");
            }
        } else {
            System.out.println("You have not reached the required level for this ability.");
        }
        caster.setLastAbility(this);
    }

    //gets how many levels above the requirement the user is. to be used as a scaling multiplier.
    public double getLevelAdjustment(Character caster){
        double adjustment = 1;
        int levelDifference =  caster.getLevel() - levelRequirement;
        //if user is 1 level above the requirement, then it'll do 1.5x dmg
        //if user is 2 levels above, it'll do 2x dmg:
            // (leveldifference = 2)
            // 2*.5 = 1
            // 1+1 = 2
            // 2x multiplier
        //may need to be tuned down.
        if(levelDifference > 0) {
            adjustment = (levelDifference*.5)+1;
        }

        return adjustment;
    }

}
