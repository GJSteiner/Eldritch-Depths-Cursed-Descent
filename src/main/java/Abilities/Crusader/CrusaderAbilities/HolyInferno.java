package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class HolyInferno extends CrusaderAbility {
    private static final String NAME = "Holy Inferno";
    private static final String DESCRIPTION = "Deals 20 damage to all enemies + 0.5 magic.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 20;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static final boolean AOE = true;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Fire";

    public HolyInferno() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

        for(Enemy target : targets) {
            checkHFM(caster, target);

            double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
            double realDamage = target.takeDamage(totalDamage);

            System.out.println(caster.getName() + " casts Holy Inferno!");
            System.out.println(caster.getName() + " deals " + realDamage + " damage to " + target.getName() + ".");
        }
    }
}
