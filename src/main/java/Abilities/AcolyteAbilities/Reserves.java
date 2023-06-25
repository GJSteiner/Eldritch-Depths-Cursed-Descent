package Abilities.AcolyteAbilities;
import Abilities.Ability;
import Characters.Character;

public class Reserves extends Ability {
    private static final String NAME = "Reserves";
    private static final String DESCRIPTION = "The health cost of your blood spells is halved.";
    private static final int LEVEL_REQUIREMENT = 4;

    public Reserves() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT, 0);
    }


    @Override
    public void useAbility(Character caster, Character target) {

    }
}

