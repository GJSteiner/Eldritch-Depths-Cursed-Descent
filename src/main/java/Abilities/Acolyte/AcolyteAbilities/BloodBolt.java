package Abilities.Acolyte.AcolyteAbilities;

import Abilities.Ability;
import Abilities.Acolyte.AcolyteAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class BloodBolt extends AcolyteAbility {
    private static final String NAME = "Blood Bolt";
    private static final String DESCRIPTION = "Deals 5 damage + 0.5 magic. You lose 5 health.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final double DAMAGE = 5;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static final double SELF_DAMAGE = 5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Blood";



    public BloodBolt() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double modifiedSelfDamage = checkReserves(caster, SELF_DAMAGE);
        if (caster.getHealth() > modifiedSelfDamage){
            double totalDamage = (DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER));
            target.takeDamage(totalDamage);
            caster.takeDamage(modifiedSelfDamage);

            System.out.println(caster.getName() + " casts Blood Bolt on " + target.getName() + "!");
            System.out.println(caster.getName() + " deals " + totalDamage + " damage and loses " + modifiedSelfDamage + " health.");
        }
        else {
            System.out.println(caster.getName() + " tried to use Blood Bolt, but doesn't have enough health to use this ability.");
        }



    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
