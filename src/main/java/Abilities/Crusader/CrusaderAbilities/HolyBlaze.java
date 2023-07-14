package Abilities.Crusader.CrusaderAbilities;

import Abilities.Ability;
import Abilities.Crusader.CrusaderAbility;
import Characters.Character;
import Characters.Enemies.Enemy;

import java.util.List;

public class HolyBlaze extends CrusaderAbility {
    private static final String NAME = "Holy Blaze";
    private static final String DESCRIPTION = "Deals .5 magic damage.";
    private static final int LEVEL_REQUIREMENT = 1;
    private static final double DAMAGE = 1;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static final boolean AOE = false;
    private static final boolean DOT = false;
    private static final String ABILITY_ELEMENT = "Fire";

    public HolyBlaze() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0, AOE, DOT, ABILITY_ELEMENT);
    }

    @Override
    public void executeAbility(Character caster, Character target) {
        checkHFM(caster, target);
        double totalDamage = DAMAGE + (caster.getMagic() * MAGIC_MULTIPLIER);
        target.takeDamage(totalDamage);

        System.out.println(caster.getName() + " casts Holy Blaze!");
        System.out.println(caster.getName() + " deals " + totalDamage + " damage to " + target.getName() + ".");

    }

    @Override
    protected void executeAbilityAoe(Character caster, List<Enemy> targets) {

    }
}
