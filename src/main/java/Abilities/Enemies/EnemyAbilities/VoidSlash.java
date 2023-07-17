package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class VoidSlash extends Ability {
    private static final String NAME = "Void Slash";
    private static final String DESCRIPTION = "Doubles in damage each time it's used in succession.";
    private static final int LEVEL_REQUIREMENT = 9;
    private static final double DAMAGE = 50;
    private static final double SCALING = 1.5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Void";


    public VoidSlash() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        double adjustedDamage = caster.getLevel()*DAMAGE;
        boolean consecutive = (caster.getLastAbility() == this);
        if(consecutive){
            adjustedDamage*=SCALING;
            System.out.println(caster.getName() + " casts " + NAME + " again, dealing increased damage.");
        }
        double realDamage = target.takeDamage(adjustedDamage);

        System.out.println(caster.getName() + " casts " + NAME +  " on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + realDamage + " damage.");
    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
