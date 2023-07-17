package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class VoidFire extends Ability {
    private static final String NAME = "Void Fire";
    private static final String DESCRIPTION = "Ignites the target with a blaze of purple flame.";
    private static final int LEVEL_REQUIREMENT = 6;
    private static final double DAMAGE = 30;
    private static final double DOT_DAMAGE = 10;
    private static final int DOT_ROUNDS = 2;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    private static final String ABILITY_ELEMENT = "Fire";


    public VoidFire() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double realDamage = target.takeDamage(DAMAGE);
        double adjustedDot = DOT_DAMAGE*getLevelAdjustment(caster);
        target.applyDamageOverTime(NAME, adjustedDot, DOT_ROUNDS);

        System.out.println(caster.getName() + " casts " + NAME + " on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage and ignites the target for " + adjustedDot + " for " + DOT_ROUNDS +".");

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
