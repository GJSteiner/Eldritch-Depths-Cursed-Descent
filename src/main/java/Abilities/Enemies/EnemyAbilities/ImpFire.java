package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;

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
        target.takeDamage(DAMAGE);

        System.out.println(caster.getName() + " casts Imp Fire on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + DAMAGE + " damage.");
    }
}
