package Abilities.AcolyteAbilities;

import Abilities.Ability;
import Characters.Character;

public class BloodRain extends Ability {
    private static final String NAME = "Blood Rain";
    private static final String DESCRIPTION = "Deals 20 damage to all enemies + 0.5 magic. You lose 30 health.";
    private static final int LEVEL_REQUIREMENT = 5;
    private static final double DAMAGE = 20;
    private static final double MAGIC_MULTIPLIER = 0.5;
    private static final double SELF_DAMAGE = 30;

    public BloodRain() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0);
    }

    @Override
    public void useAbility(Character user, Character target) {
        double totalDamage = DAMAGE + (user.getMagic() * MAGIC_MULTIPLIER);
        target.takeDamage(totalDamage);
        user.takeDamage(SELF_DAMAGE);
    }
}