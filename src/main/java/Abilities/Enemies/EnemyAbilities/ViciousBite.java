package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class ViciousBite extends Ability {
    private static final String NAME = "Vicious Bite";
    private static final String DESCRIPTION = "Bites the target, tearing into their flesh.";
    private static final int LEVEL_REQUIREMENT = 7;
    private static final double DAMAGE = 40;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Physical";


    public ViciousBite() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = caster.getLevel()*DAMAGE;
        double realDamage = target.takeDamage(adjustedDamage);

        System.out.println(caster.getName() + " bites " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
