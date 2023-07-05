package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;

public class HolyInferno extends CrusaderAbility {
    private static final String NAME = "Holy Inferno";
    private static final String DESCRIPTION = "Deals 20 damage to all enemies + 0.1 magic.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 20;
    private static final double MAGIC_MULTIPLIER = 0.1;
    private static final boolean AOE = true;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Fire";

    public HolyInferno() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        checkHFM(caster, target);

        double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
            target.takeDamage(totalDamage);

            System.out.println(caster.getName() + " casts Holy Inferno!");
            System.out.println(caster.getName() + " deals " + totalDamage + " damage to " + target.getName() + ".");

    }
}
