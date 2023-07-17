package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class HolyRadiance extends CrusaderAbility {

    private static final String NAME = "Holy Radiance";
    private static final String DESCRIPTION = "Deals 10 damage + .25 magic to all enemies.";
    private static final int LEVEL_REQUIREMENT = 2;
    private static final double DAMAGE = 10;
    private static final double MAGIC_MULTIPLIER = 0.25;
    private static final boolean AOE = true;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Holy";

    public HolyRadiance() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {
        System.out.println(caster.getName() + " casts Holy Radiance!");
        double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);

        for (Enemy target : targets) {
            checkHFM(caster, target);
            double realDamage = target.takeDamage(totalDamage);
            System.out.println(caster.getName() + " deals " + realDamage + " damage to " + target.getName() +  ".");

        }


    }
}
