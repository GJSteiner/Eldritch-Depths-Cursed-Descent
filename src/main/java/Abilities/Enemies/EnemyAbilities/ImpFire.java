package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class ImpFire extends Ability {
    private static final String NAME = "Imp Fire";
    private static final String DESCRIPTION = "Launches a fast-moving ball of purple flame.";
    private static final int LEVEL_REQUIREMENT = 2;
    private static final double DAMAGE = 30;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Fire";


    public ImpFire() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double realDamage = target.takeDamage(DAMAGE);

        System.out.println(caster.getName() + " casts " + NAME + " on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
