package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class DarkBlast extends Ability {
    private static final String NAME = "Dark Blast";
    private static final String DESCRIPTION = "Unleashes a blast of dark energy.";
    private static final int LEVEL_REQUIREMENT = 0;
    private static final double DAMAGE = 5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Void";


    public DarkBlast() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = (caster.getLevel()+1)*DAMAGE;
        double realDamage = target.takeDamage(adjustedDamage);

        System.out.println(caster.getName() + " casts " + NAME +  " on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
