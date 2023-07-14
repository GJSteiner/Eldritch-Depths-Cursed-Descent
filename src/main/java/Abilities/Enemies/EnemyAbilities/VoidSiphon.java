package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class VoidSiphon extends Ability {
    private static final String NAME = "Void Siphon";
    private static final String DESCRIPTION = "Drains the target's health each turn.";
    private static final int LEVEL_REQUIREMENT = 2;
    private static final double DAMAGE = 3;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    public static final int DOT_ROUND = 5;
    private static final String ABILITY_ELEMENT = "Void";



    public VoidSiphon() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        target.applyDamageOverTime(NAME, DAMAGE, DOT_ROUND);
        caster.applyHealOverTime(NAME, DAMAGE, DOT_ROUND);
        System.out.println(caster.getName() + " casts Void Siphon on " + target.getName() + "!");
        System.out.println(caster.getName() + " begins draining the target's health. The target is taking " + DAMAGE +
                " damage each round for " + DOT_ROUND + " rounds.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
