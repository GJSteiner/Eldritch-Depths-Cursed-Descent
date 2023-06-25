package Abilities.AcolyteAbilities;

import Abilities.Ability;
import Characters.Character;

public class BloodBolt extends Ability {
    private static final String NAME = "Blood Bolt";
    private static final String DESCRIPTION = "Deals 5 damage + 0.5 magic. You lose 5 health.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final int DAMAGE = 5;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static final int SELF_DAMAGE = 5;

    public BloodBolt() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        if (caster.getHealth() > SELF_DAMAGE){
            double totalDamage = (DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER));
            target.takeDamage(totalDamage);
            caster.takeDamage(SELF_DAMAGE);

            System.out.println(caster.getName() + " casts Blood Bolt on " + target.getName() + "!");
            System.out.println(caster.getName() + " deals" + totalDamage + " damage and loses " + SELF_DAMAGE + " health.");
        }
        else {
            System.out.println(caster.getName() + " tried to use Blood Bolt, but doesn't have enough health to use this ability.");
        }



    }
}
