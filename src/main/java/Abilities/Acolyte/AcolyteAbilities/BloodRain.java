package Abilities.Acolyte.AcolyteAbilities;

import Abilities.Ability;
import Abilities.Acolyte.AcolyteAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class BloodRain extends AcolyteAbility {
    private static final String NAME = "Blood Rain";
    private static final String DESCRIPTION = "Deals 20 damage to all enemies + 0.5 magic. You lose 10 health per target.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 20;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static double SELF_DAMAGE = 10;
    private static final boolean AOE = true;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Blood";


    public BloodRain() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    public void executeAbilityAoe(Character caster, List<Enemy> targets) {
        double modifiedSelfDamage = checkReserves(caster, SELF_DAMAGE);
        if (caster.getHealth() > modifiedSelfDamage) {
            System.out.println(caster.getName() + " casts Blood Rain!");
            double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
            for (Enemy target : targets) {
                double realDamage = target.takeDamage(totalDamage);
                System.out.println(caster.getName() + " deals " + realDamage + " damage to " + target.getName() + " and loses " + modifiedSelfDamage + " health.");
            }
            caster.takeDamage(modifiedSelfDamage);


        } else {
            System.out.println(caster.getName() + " tried to use Blood Rain, but doesn't have enough health to use this ability.");
        }
    }

    @Override
    protected void executeAbility(Character caster, Character target) {

    }
}