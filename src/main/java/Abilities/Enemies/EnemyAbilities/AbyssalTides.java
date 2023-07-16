package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class AbyssalTides extends Ability {
    private static final String NAME = "AbyssalTides";
    private static final String DESCRIPTION = "Cleanses the user of all DoTs and deals significant damage.";
    private static final int LEVEL_REQUIREMENT = 9;
    private static final double DAMAGE = 50;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Water";


    public AbyssalTides() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = caster.getLevel()*DAMAGE;
        target.takeDamage(adjustedDamage);
        caster.removeDamageOverTime();

        System.out.println(caster.getName() + " casts " + NAME +  " on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + adjustedDamage + " damage.");
        System.out.println(caster.getName() + " cleanses all damage over time effects.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}