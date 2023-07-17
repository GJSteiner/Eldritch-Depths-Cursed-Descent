package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class HolyIgnition extends CrusaderAbility {
    private static final String NAME = "Holy Ignition";
    private static final String DESCRIPTION = "Deals .25 magic each round";
    private static final int LEVEL_REQUIREMENT = 3;
    private static final double DAMAGE = 0;
    private static final double MAGIC_MULTIPLIER = 0.25;
    private static final boolean AOE = false;
    private static final boolean DOT = true;
    private static final boolean STACKING = false;

    private static final int DOT_ROUNDS = 6;
    private static final String ABILITY_ELEMENT = "Fire";
    private static final String DOT_ELEMENT = "Fire";

    public HolyIgnition() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        checkHFM(caster, target);

        double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
        target.applyDamageOverTime(NAME, totalDamage, DOT_ROUNDS, DOT_ELEMENT, STACKING);

        System.out.println(caster.getName() + " casts Holy Ignition!");
        System.out.println(caster.getName() + " ignites the target. The target is taking " + totalDamage +
                " damage each round for " + DOT_ROUNDS + " rounds.");

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
