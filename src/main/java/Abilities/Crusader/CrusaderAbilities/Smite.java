package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;

public class Smite extends CrusaderAbility {
    private static final String NAME = "Smite";
    private static final String DESCRIPTION = "Deals a powerful blow to the enemy.";
    private static final int LEVEL_REQUIREMENT = 0;
    private static final double DAMAGE = 5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Holy";

    public Smite() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, DAMAGE, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        checkHFM(caster, target);
        target.takeDamage(DAMAGE);

        System.out.println(caster.getName() + " smites " + target.getName() + "!");
        System.out.println(caster.getName() + " deals " + DAMAGE + " damage.");
    }
}