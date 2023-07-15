package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;
import Systems.DamageOverTime;

public class CallOfTheVoid extends Passive {
    private static final String NAME = "Call of the Void";
    private static final String DESCRIPTION = "Applies a stacking DoT with each attack.";
    private static final Double DAMAGE = 20.0;
    private static final int DURATION = 5;
    private static final int LEVEL_REQUIREMENT = 10;


    public CallOfTheVoid() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyCallOfTheVoid(Character character, Character target){
        DamageOverTime cotv = new DamageOverTime("Call of the Void", DAMAGE, DURATION);
        cotv.setStacking(true);
        target.applyDamageOverTime(cotv.getDotName(), cotv.getDamagePerRound(), cotv.getRemainingRounds());
    }
}
