package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class HellBlitz extends Ability {
    private static final String NAME = "Hell Blitz";
    private static final String DESCRIPTION = "Wraps the user in void flames and charges at the target.";
    private static final int LEVEL_REQUIREMENT = 8;
    private static final double DAMAGE = 50;
    private static final double DOT_DAMAGE = 5;
    private static final int DOT_ROUNDS = 5;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    private static final String ABILITY_ELEMENT = "Fire";


    public HellBlitz() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = caster.getLevel()*DAMAGE;
        double realDamage = target.takeDamage(adjustedDamage);
        target.applyDamageOverTime(NAME, DOT_DAMAGE, DOT_ROUNDS);


        System.out.println(caster.getName() + " charges " + target.getName() + " with" + NAME + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage and ignites the target for " + DOT_DAMAGE + " for " + DOT_ROUNDS +".");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
