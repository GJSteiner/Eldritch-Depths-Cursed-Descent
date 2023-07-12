package Abilities.Enemies.EnemyAbilities;

import Abilities.Ability;
import Characters.Character;

public class VoidDrain extends Ability {
    private static final String NAME = "Void Siphon";
    private static final String DESCRIPTION = "Drains the target's health.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final double DAMAGE = 15;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Void";


    public VoidDrain() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        target.takeDamage(DAMAGE);
        caster.heal(DAMAGE);
        System.out.println(caster.getName() + " casts Void Drain on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + DAMAGE + " damage and heals for " + DAMAGE + ".");
    }
}
