package Abilities.Corrupted;

import Abilities.Ability;

public abstract class CorruptedAbility extends Ability {
    public CorruptedAbility(String name, String description, int levelRequirement, double damage, boolean aoe, String abilityElement) {
        super(name, description, levelRequirement, damage, aoe, true, abilityElement);
    }
}
