package Abilities.Acolyte.AcolyteAbilities;

import Abilities.Ability;
import Characters.Character;

public class Drain extends Ability {
    private static final String NAME = "Drain";
    private static final String DESCRIPTION = "Deals 1.0 magic damage and heals you for the same amount.";
    private static final int LEVEL_REQUIREMENT = 3;
    private static final double MAGIC_MULTIPLIER = 1.0;
    private static final boolean AOE = false;


    public Drain() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double totalDamage = (caster.getMagic() * MAGIC_MULTIPLIER);
        target.takeDamage(totalDamage);
        caster.heal(totalDamage);
        System.out.println(caster.getName() + " casts Drain on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + totalDamage + " damage and heals for " + totalDamage + ".");
    }
}
