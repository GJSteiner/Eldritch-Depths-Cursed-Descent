package Abilities.Acolyte.AcolyteAbilities;

import Abilities.Ability;
import Abilities.Acolyte.AcolyteAbility;
import Characters.Character;

public class BloodRain extends AcolyteAbility {
    private static final String NAME = "Blood Rain";
    private static final String DESCRIPTION = "Deals 20 damage to all enemies + 0.5 magic. You lose 10 health per target.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 20;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static double SELF_DAMAGE = 30;
    private static final boolean AOE = true;


    public BloodRain() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double modifiedSelfDamage = checkReserves(caster, SELF_DAMAGE);
        if(caster.getHealth() > modifiedSelfDamage) {
            double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
            target.takeDamage(totalDamage);
            caster.takeDamage(modifiedSelfDamage);

            System.out.println(caster.getName() + " casts Blood Rain!");
            System.out.println(caster.getName() + " deals" + totalDamage + " damage to " + target.getName() + " and loses " + modifiedSelfDamage + " health.");

        }
        else {
            System.out.println(caster.getName() + " tried to use Blood Rain, but doesn't have enough health to use this ability.");
        }
    }
}