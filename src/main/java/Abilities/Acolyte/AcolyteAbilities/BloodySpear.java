package Abilities.Acolyte.AcolyteAbilities;

import Abilities.Acolyte.AcolyteAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.AbstractCollection;
import java.util.List;

public class BloodySpear extends AcolyteAbility {
    private static final String NAME = "Bloody Spear";
    private static final String DESCRIPTION = "Deals 10 damage + 0.75 magic. You lose 10 health.";
    private static final int LEVEL_REQUIREMENT = 2;
    private static final double DAMAGE = 10;
    private static final double MAGIC_MULTIPLIER = 0.75;
    private static final double SELF_DAMAGE = 10;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Blood";



    public BloodySpear() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double modifiedSelfDamage = checkReserves(caster, SELF_DAMAGE);
        if (caster.getHealth() > modifiedSelfDamage){
            double totalDamage = (DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER));
            double realDamage = target.takeDamage(totalDamage);
            caster.takeDamage(modifiedSelfDamage);

            System.out.println(caster.getName() + " casts Bloody Spear on " + target.getName() + "!");
            System.out.println(caster.getName() + " deals " + realDamage + " damage and loses " + modifiedSelfDamage + " health.");
        }
        else {
            System.out.println(caster.getName() + " tried to use Bloody Spear, but doesn't have enough health to use this ability.");
        }
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
