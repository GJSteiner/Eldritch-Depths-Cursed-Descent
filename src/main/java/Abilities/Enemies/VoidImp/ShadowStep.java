package Abilities.Enemies.VoidImp;

import Abilities.Ability;
import Characters.Character;

public class ShadowStep extends Ability {
    private static final String NAME = "Shadow Step";
    private static final String DESCRIPTION = "Teleports behind the target and launches a surprise attack.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final double DAMAGE = 15;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Void";


    public ShadowStep() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        target.takeDamage(DAMAGE);

        System.out.println(caster.getName() + " casts Shadow Step on " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + DAMAGE + " damage.");
    }
}
