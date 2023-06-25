package Abilities.AcolyteAbilities;

import Abilities.Ability;
import Characters.Character;

public class VoidBolt extends Ability {
    private static final String NAME = "Void Bolt";
    private static final String DESCRIPTION = "Deals 5 damage.";
    private static final int LEVEL_REQUIREMENT = 0;
    private static final double DAMAGE = 5;

    public VoidBolt() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        target.takeDamage(DAMAGE);

        System.out.println(caster.getName() + " casts Blood Bolt on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals" + DAMAGE + " damage.");
    }
}
