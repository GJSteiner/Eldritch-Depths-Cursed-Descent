package Abilities.Enemies.EnemyPassives;

import Abilities.Passive;
import Characters.Character;
import Systems.DamageOverTime;

public class CallOfTheVoid extends Passive {
    private static final String NAME = "Call of the Void";
    private static final String DESCRIPTION = "Applies a stacking DoT with each attack.";
    private static final Double DAMAGE = 20.0;
    private static final int DURATION = 5;
    private static final boolean STACKING = true;

    private static final int LEVEL_REQUIREMENT = 10;
    private static final String DOT_ELEMENT = "Void";


    public CallOfTheVoid() {
        super(NAME, DESCRIPTION, LEVEL_REQUIREMENT);
    }

    public void applyCallOfTheVoid(Character character, Character target){
        DamageOverTime cotv = new DamageOverTime("Call of the Void", DAMAGE, DURATION, DOT_ELEMENT, STACKING);
        cotv.setStacking(true);

        DamageOverTime existingDot = target.getExistingDamageOverTimeEffect(cotv.getDotName());
        if (existingDot != null && existingDot.isStacking()) {
            System.out.println(target.getName() + " already has " + cotv.getDotName() +
                    " active. Current intensity: " + existingDot.getDamagePerRound());
        }


        target.applyDamageOverTime(cotv.getDotName(), cotv.getDamagePerRound(), cotv.getRemainingRounds(), cotv.getElement(), STACKING);
        DamageOverTime updatedDot = target.getExistingDamageOverTimeEffect(cotv.getDotName());
        System.out.println(cotv.getDotName() + " applied to " + target.getName() + "!");
        if(existingDot != null && existingDot.isStacking()) {
            System.out.println(cotv.getDotName() + " is now doing " + updatedDot.getDamagePerRound() + " damage per round.");
        }
    }
}
